# Проект автоматизации тестирования сайта GeekBrains

Проект был сделан в рамках курса "ООП в Java".  
Тесты написаны для сайта https://geekbrains.ru/

## Сводка
  
  - [Требования](#Требования)
    - [Установка JDK](#Установка-JDK)
    - [Установка Maven](#Установка-Maven)
  - [Скачивание и запуск проекта](#Скачивание-и-запуск-проекта)
  - [Информация о проекте](#Информация-о-проекте)
    - [Информация по тестам](#Информация-по-тестам)
    - [Используемые библиотеки](#Используемые-библиотеки)
    - [Используемые плагины](#Используемые-плагины)
  - [Автор](#Автор)
  - [Дополнительно](#Дополнительно)

## Требования

Для запуска проекта без среды разработки IDEA понадобится:

1. JDK 1.8
2. Maven 3.6.3
3. Установленный браузер Google Chrome

### Установка JDK

- Для Windows:

    Скачать Open JDK: [x32 jdk8u252-b09.1](https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09.1/OpenJDK8U-jdk_x86-32_windows_hotspot_8u252b09.msi) / [x64 jdk8u252-b09.1](https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09.1/OpenJDK8U-jdk_x64_windows_hotspot_8u252b09.msi)

    Запустить скачанный `.msi` файл.
    
    В процессе установки отметить пункты:  
      - Add to PATH  
      - Set JAVA_HOME variable  
    
    Проверить установку:
    
    ```cmd
    C:\>java -version
    openjdk version "1.8.0_252"
    OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_252-b09)
    OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.252-b09, mixed mode)
    
    C:\>echo %PATH%
    C:\Program Files\AdoptOpenJDK\jdk-8.0.252.09-hotspot\bin;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\System32\WindowsPowerShell\v1.0\;C:\Windows\System32\OpenSSH\;C:\Users\Nameless\AppData\Local\Microsoft\WindowsApps;
    
    C:\>echo %JAVA_HOME%
    C:\Program Files\AdoptOpenJDK\jdk-8.0.252.09-hotspot\
    ```

- Для Linux:
    
    ```ShellSession
    $ sudo apt install openjdk-8-jdk
    ```

    Добавить переменную окружения `JAVA_HOME`:
    
    ```ShellSession
    $ sudo update-alternatives --config java
    There is only one alternative in link group java (providing /usr/bin/java): /usr/lib/jvm/java-8-openjdk-arm64/jre/bin/java
    Nothing to configure.
    $ sudo nano /etc/environment
  
    PATH=...
    JAVA_HOME="/usr/lib/jvm/java-8-openjdk-arm64/jre/bin/java"
    ```

    Проверить успешное добавление переменной окружения:
    
    ```ShellSeesion
    $ source /etc/environment
    $ echo $JAVA_HOME
    /usr/lib/jvm/java-8-openjdk-arm64/jre/bin/java
    ```

- Для macOS:

    Скачать Open JDK: [jdk8u252-b09.1](https://github.com/AdoptOpenJDK/openjdk8-binaries/releases/download/jdk8u252-b09.1/OpenJDK8U-jdk_x64_mac_hotspot_8u252b09.pkg)

    Запустить скачанный `.pkg` файл.
    
    Проверить установку:
    
    ```
    $ java -version
    openjdk version "1.8.0_252"
    OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_252-b09)
    OpenJDK 64-Bit Server VM (AdoptOpenJDK)(build 25.252-b09, mixed mode)
    ```
  
    Добавить переменную окружения `JAVA_HOME`:
    
    ```
    $ nano ~/.bash_profile    
  
    export JAVA_HOME=$(/usr/libexec/java_home)
    ```
  
    Проверить успешное добавление переменной окружения:
        
    ```ShellSeesion
    $ source ~/.bash_profile
    $ echo $JAVA_HOME
    /Library/Java/JavaVirtualMachines/adoptopenjdk-8.jdk/Content/Home
    ```
        
### Установка Maven

Скачать Maven: [apache-maven-3.6.3-bin.zip](https://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.zip)

Распаковать скачанный архив в желаемую директорию.

- Для Windows:
    
    Добавить в переменную окружения `PATH` путь до папки `bin`:
    
    ```cmd
    C:\>setx path "%path%;C:\Library\apache-maven-3.6.3\bin"
    ```  
    
    Перезапустить командную строку и проверить установку:
    
    ```cmd
    C:\>mvn -v
    C:\
    Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
    Maven home: C:\Library\apache-maven-3.6.3\bin\..
    Java version: 1.8.0_252, vendor: AdoptOpenJDK, runtime: C:\Program Files\AdoptOpenJDK\jdk-8.0.252.09-hotspot\jre
    Default locale: ru_RU, platform encoding: Cp1251
    OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"
    ```

- Для Linux и macOS:
    
    Добавить в переменную окружения `PATH` путь до папки `bin`:
    
    ```ShellSession
    $ export PATH=path_to_apache/apache-maven-3.6.3/bin:$PATH
    ```
  
    Проверить установку:
    
    ```ShellSession
    $ mvn -v
    Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
    Maven home: /opt/apache-maven-3.6.3
    Java version: 1.8.0_252, vendor: Private Build, runtime: /usr/lib/jvm/java-8-openjdk-amd64/jre
    Default locale: ru_RU, platform encoding: UTF-8
    OS name: "linux", version: "5.3.0-51-generic", arch: "amd64", family: "unix"
    ```

## Скачивание и запуск проекта

Возможно скачать архив или клонировать проект при наличии git.

[Ссылка на скачивание архива](https://github.com/a-tikhomirov/geekbrains-at/archive/master.zip)

Команда для клонирования проекта:

```
$ git clone https://github.com/a-tikhomirov/geekbrains-at.git
```

Для запуска проекта необходимо в командной строке перейти в директорию проекта и выполнить команду:

```
mvn clean test allure:serve
```

В результаты выполнения данной команды:
- При необходимости будут скачаны зависимости проекта;
- В параллельном режиме будут запущены 4 теста;
- По окончании тестов будет открыт браузер с отчетом по выполненным тестам.

## Информация о проекте

### Информация по тестам

#### Проверка авторизации на странице https://geekbrains.ru/login

1. Перейти на страницу авторизация https://geekbrains.ru/login
2. Ввести логин : hao17583@bcaoo.com
3. Пароль: hao17583
4. Нажать кнопку войти
5. Проверить что отобразилась страница "Главная" 
---
#### Проверка результатов фильтрации на странице https://geekbrains.ru/courses

1. Перейти на страницу авторизация https://geekbrains.ru/login
2. Ввести логин : hao17583@bcaoo.com
3. Пароль: hao17583
4. Нажать кнопку войти
5. Проверить что отобразилась страница "Главная"
6. Нажать в навигации "Курсы"
7. Нажать в шапке сайта "Курсы"
8. Выбрать в фильтрах чекбокс "Бесплатные"
9. Выбрать в фильтрах чекбокс "Тестирование"
10. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 1"
11. Проверить что в выборке отображается курсы "Тестирование ПО. Уровень 2"
---
#### Проверка элементов навигации sidebar страницы https://geekbrains.ru/career

1. Перейти на страницу авторизация https://geekbrains.ru/career
2. Нажать в sidebar навигации ["Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера"]
3. Проверить элементы секции header и текст заголовка страницы
4. Проверить элементы секции footer
---
#### Проверка результатов поиска по ключевому слову Java

1. Перейти на сайт https://geekbrains.ru/courses
2. Нажать на кнопку Поиск
3. В поле Поиск ввести текст: java
4. Проверить что отобразились блоки и в них:  
    - Профессий не менее чем 2  
    - Курсов более 15  
    - Вебинаров больше чем 180, но меньше 300  
    - Блогов более 300  
    - Форумов не 350  
    - Тестов не 0  

### Используемые библиотеки

- selenide
- allure-selenide
- allure-junit5
- junit-jupiter-api
- junit-jupiter-engine
- junit-jupiter-params
- junit-vintage-engine
- junit-platform-engine
- junit-platform-launcher
- hamcrest
- slf4j-simple

### Используемые плагины

- maven-compiler-plugin
- maven-surefire-plugin
- allure-maven

## Автор

  - **Андрей Тихомиров** - <andrey.tikhomirov.88@gmail.com>

## Дополнительно

Этот же проект, но с использованием библиотеки _Selenium_ - ветка _selenium_based_ - https://github.com/a-tikhomirov/geekbrains-at/tree/selenium_based