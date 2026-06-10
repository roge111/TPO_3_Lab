# Исходные артефакты (до доработки)

Здесь сохранены файлы, которые были получены **автоматически** из инструментов Selenium. Они **не входят** в Gradle-сборку и служат для отчёта: что записали / сгенерировали и что изменили вручную.

| Папка | Файл | Источник | Состояние |
|-------|------|----------|-----------|
| `selenium-ide/` | `UntitledTest.java` | **Selenium IDE** — экспорт записи кликов на sravni.bet | JUnit 4, CSS-селекторы, один тест `untitled()`, без assert, только Chrome |
| `page-object-generator/` | `MainPage.java` | **Selenium Page Object Generator** (расширение браузера) | Не компилируется: дубли полей/методов, нет `PageFactory.initElements`, CSS вместо XPath |

## Финальная реализация (доработанная)

См. каталог `src/test/java/ru/itmo/tpo/lab3/`:

- `SravniBetUseCaseTests.java` — 17 сценариев TS-01 … TS-17 (на основе прецедентов из README)
- `pages/MainPage.java` — переработанный Page Object с XPath
- `support/` — WebDriver, локаторы, ожидания

Запуск: `.\gradlew.bat test` из корня проекта.

## Связь «было → стало»

| Требование лабы | Selenium IDE (`UntitledTest`) | Generator (`MainPage`) | Финальные тесты |
|-----------------|------------------------------|------------------------|-----------------|
| Запись в IDE | ✅ | — | Шаблон сценария взят за основу UC-07 (вкладки, betCard) |
| Page Object | — | ✅ (черновик) | ✅ `pages/MainPage.java` |
| XPath | ❌ CSS | ❌ CSS | ✅ |
| Chrome + Firefox | ❌ | — | ✅ `@EnumSource` |
| 17 прецедентов | ❌ 1 тест | ❌ не подключён | ✅ TS-01 … TS-17 |
| Assert + WebDriverWait | ❌ | ❌ | ✅ |
