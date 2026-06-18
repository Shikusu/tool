# Tools

![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)
![Platform: Android](https://img.shields.io/badge/platform-Android-3DDC84.svg)

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/cdb2034c-19cb-4ee5-a8b5-1888cd31d0db" width="220" alt="Screenshot 1" /></td>
    <td><img src="https://github.com/user-attachments/assets/df0c1bc6-57bd-4ce3-aca1-96693c2adb86" width="220" alt="Screenshot 2" /></td>
    <td><img src="https://github.com/user-attachments/assets/c45d9d0d-5256-4cd2-a809-3434dec91077" width="220" alt="Screenshot 3" /></td>
    <td><img src="https://github.com/user-attachments/assets/a332775c-7369-44ee-8a5c-593fe13f21ce" width="220" alt="Screenshot 4" /></td>
    <td><img src="https://github.com/user-attachments/assets/c683712c-f7c3-4456-b992-6c55d9911161" width="220" alt="Screenshot 5" /></td>
    <td><img src="https://github.com/user-attachments/assets/77200b48-1f77-4a9b-9f3b-b7a71dd14d6b" width="220" alt="Screenshot 6" /></td>
    <td><img src="https://github.com/user-attachments/assets/7333e687-257c-4eba-8a8a-7645dfb7787d" width="220" alt="Screenshot 7" /></td>
  </tr>
</table>

A lightweight Android app bundling a few everyday calculators into one place: a BMI calculator, a currency converter, and a multiplication table generator. The interface is in French.

## Features

**IMC Calculator (BMI)**
Enter your height (in meters) and weight (in kg) to get your Body Mass Index, classified into standard categories from "Dénutrition ou famine" to "Obésité morbide."

**Currency Converter**
Convert between 39 currencies, including MGA (Malagasy Ariary), USD, EUR, GBP, JPY, and more. Exchange rates are bundled locally, so conversions work instantly and offline.

**Multiplication Table**
Enter a number from 0 to 10 and get its full multiplication table (1 through 10).

## Tech stack

- Java
- Android SDK: min 24 (Android 7.0), target/compile 36
- Gradle (Kotlin DSL) with Android Gradle Plugin 8.9.1
- AndroidX (AppCompat, Material Components, ConstraintLayout), View Binding

## Getting started

### Prerequisites

- Android Studio (latest stable recommended)
- JDK 11

### Build & run

Clone the repo:

```bash
git clone https://github.com/Shikusu/tool.git
```

Then open the project in Android Studio and run the `app` configuration on an emulator or device (Android 7.0+).

Or build a debug APK from the command line:

```bash
./gradlew assembleDebug
```

The APK will be generated at `app/build/outputs/apk/debug/app-debug.apk`.

## Project structure

```
app/src/main/java/mg/application/cercle/
├── MainActivity.java       # Navigation drawer and entry point
├── IMCActivity.java        # BMI calculator
├── CurrencyActivity.java   # Currency converter
└── Multiplication.java     # Multiplication table generator
```

## License

This project is licensed under the MIT License — see [LICENSE](LICENSE) for details.
