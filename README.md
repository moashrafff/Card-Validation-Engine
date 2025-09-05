# 💳 Bank Card Validator Engine

A lightweight Kotlin library for **validating and detecting payment card details**.  
This repo contains only the **core validation engine** (pure Kotlin/JVM).  
👉 The UI components are in a separate repo.

---

## ✨ Features

- 🔍 **Card brand detection**  
  Detect Visa, Mastercard, and other brands based on card number patterns.

- ✅ **Validation utilities**  
  - Card number format check (digits only)  
  - Luhn checksum validation  
  - CVV format & brand-specific length validation  
  - Expiry date parsing and expiration check  

- 📦 **Pure Kotlin/JVM**  
  Works on **JVM, Android, and multiplatform projects**.

---

## 📦 Installation

Add [JitPack](https://jitpack.io) to your project:

```gradle
repositories {
    maven { url = uri("https://jitpack.io") }
}
```

Then add the dependency (replace `TAG` with the latest release tag):

```gradle
implementation("com.github.moashrafff:bank-card-validator-engine:TAG")
```

---

## 🚀 Usage

### 🔍 Card Brand Detection

```kotlin
import com.bankcardvalidator.api.CardBrandDetector

val brand = CardBrandDetector.detectCardType("4111111111111111")
println(brand) // VISA

val supported = CardBrandDetector.isSupportedCard("4111111111111111")
println(supported) // true

val cvvLength = CardBrandDetector.getRequiredCvvLength("4111111111111111")
println(cvvLength) // 3
```

---

### ✅ Card Number Validation

```kotlin
import com.bankcardvalidator.api.CardValidator
import com.bankcardvalidator.result.CardNumberValidationResult

val result: CardNumberValidationResult = CardValidator.isCardNumberValid("4111111111111111")

when (result) {
    CardNumberValidationResult.Valid -> println("Card number is valid ✅")
    CardNumberValidationResult.InvalidFormat -> println("Invalid format ❌")
    CardNumberValidationResult.UnknownBrand -> println("Unknown brand ⚠️")
    CardNumberValidationResult.InvalidLuhn -> println("Failed Luhn check ❌")
}
```

---

### 🔒 CVV Validation

```kotlin
import com.bankcardvalidator.api.CardValidator
import com.bankcardvalidator.cvvValidationEngine.result.CvvValidationResult

val cvvResult: CvvValidationResult = CardValidator.isCvvValid("4111111111111111", "123")

when (cvvResult) {
    CvvValidationResult.Valid -> println("CVV valid ✅")
    CvvValidationResult.InvalidFormat -> println("Invalid format ❌")
    CvvValidationResult.InvalidLength -> println("Invalid length ⚠️")
}
```

---

### 📅 Expiry Date Validation

```kotlin
import com.bankcardvalidator.api.CardValidator
import com.bankcardvalidator.result.ExpiryValidationResult

val expiryResult: ExpiryValidationResult = CardValidator.isExpiryDateValid("12/25")

when (expiryResult) {
    ExpiryValidationResult.Valid -> println("Expiry valid ✅")
    ExpiryValidationResult.Expired -> println("Card expired ❌")
    ExpiryValidationResult.InvalidMonth -> println("Invalid month ⚠️")
    ExpiryValidationResult.InvalidFormat -> println("Invalid format ❌")
}
```

---

## 📚 Examples

- Detect supported card brands
- Validate number format, Luhn checksum, and length
- Ensure CVV and expiry are valid before processing payments

---

## ⚖️ License

This project is licensed under the [MIT License](LICENSE).  
You are free to use it in commercial and open-source projects, with attribution.

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!  
Feel free to open a pull request or start a discussion.
