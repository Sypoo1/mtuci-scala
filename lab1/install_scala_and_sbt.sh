#!/bin/bash

# Функция для автоматического ответа "Y" на все вопросы
auto_yes() {
    yes "" | "$@" || return 1
}

# Функция для вывода сообщений об ошибках
error_exit() {
    echo "$1" 1>&2
    exit 1
}

# Проверка архитектуры процессора
ARCH=$(uname -m)
case "$ARCH" in
    x86_64)
        COURSIER_URL="https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-linux.gz"
        ;;
    aarch64|arm64)
        COURSIER_URL="https://github.com/VirtusLab/coursier-m1/releases/latest/download/cs-aarch64-pc-linux.gz"
        ;;
    *)
        error_exit "Неподдерживаемая архитектура: $ARCH"
        ;;
esac

# Проверка наличия curl и gzip
if ! command -v curl &> /dev/null; then
    error_exit "curl не установлен. Установите его и повторите попытку."
fi
if ! command -v gzip &> /dev/null; then
    error_exit "gzip не установлен. Установите его и повторите попытку."
fi

# Установка Coursier
echo "Установка Coursier..."
curl -fL "$COURSIER_URL" | gzip -d > cs || error_exit "Не удалось скачать или распаковать Coursier."
chmod +x cs || error_exit "Не удалось сделать cs исполняемым."

# Автоматическая установка с подтверждением всех шагов
echo "Запуск coursier setup с автоматическими ответами..."
auto_yes ./cs setup || error_exit "Не удалось выполнить coursier setup."

# Очистка временного файла
rm -f cs

# Активация изменений в ~/.profile
echo "Активация изменений в ~/.profile..."
source ~/.profile || error_exit "Не удалось активировать ~/.profile."

# Проверка установки
echo "Проверка установки..."
if ! command -v scala &> /dev/null; then
    error_exit "Scala не установлена."
fi
if ! command -v sbt &> /dev/null; then
    error_exit "sbt не установлен."
fi

echo "Scala и sbt успешно установлены через Coursier!"
echo "Все изменения активированы. Вы можете использовать Scala и sbt прямо сейчас."
