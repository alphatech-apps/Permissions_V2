
# 📌 Permissions_V2            – Android Runtime & System Permission Manager  

A powerful and easy-to-use Android library to handle both **runtime permissions** and **special/system accesses** with clean APIs and modern Material dialogs (BottomSheets).  

---

## ✨ Features  

### 🔑 Runtime Permissions  
- Camera
- Storage
- Media (Image, Audio, Video)  
- Location (Fine & Coarse)  
- Contacts
- Phone
- Call Logs  
- SMS (Send, Read, Receive)  
- Microphone / Audio Recording  
- Notifications  

### ⚙️ Special System Permissions & Access  
- Device Admin  
- Accessibility Service  
- Display over other apps (Overlay)  
- All Files Access (Manage External Storage)  
- Ignore Battery Optimization  
- Usage Access  
- Modify System Settings  
- Do Not Disturb Access  
- Install Unknown Apps  
- Notification Listener Access  
- Media Projection (Screen Capture)  
- GPS Enable  

---

## 🚀 Installation  
[![](https://jitpack.io/v/alphatech-apps/Permissions_V2.svg)](https://jitpack.io/#alphatech-apps/Permissions_V2)


Add dependency via **Gradle** (jitpack.io support):  

```gradle
dependencies {
    implementation 'com.github.alphatech-apps:Permissions_V2:Latest_version'
}
```

*(If not published yet, you can import `.aar` / `.module` locally.)*  

---

## 🛠 Usage  

### ✅ Check and Request Runtime Permissions  

```java
// Check single permission
if (!PermissionsRuntime.checkCameraPermission(this)) {
    PermissionsRuntime.requestCameraPermission(this,
        "Camera permission is required to take photos.",
        true, // show BottomSheet dialog
        getDrawable(R.drawable.ic_camera));
}
```

```java
// Request multiple permissions at once
PermissionsRuntime.requestAllPermission(
    this,
    "App needs all required permissions to work properly.",
    true,
    getDrawable(R.drawable.ic_permission));
```

---

### ⚙️ Check and Request Special Access  

```java
// Check Device Admin
if (!PermissionAccess.isDeviceAdminEnabled(this, MyDeviceAdminReceiver.class)) {
    PermissionAccess.requestDeviceAdmin(this, MyDeviceAdminReceiver.class);
}
```

```java
// Request Overlay Permission
PermissionAccess.requestSystemAlert(this);
```

```java
// Request All Files Access (Scoped Storage bypass)
PermissionAccess.requestManageStorage(this);
```

---

## 📂 Helpers  

- `PermissionsRuntime_helper` → Runtime permissions, codes, messages & icons  
- `PermissionAccess_helper` → System accesses (GPS, Overlay, Device Admin, etc.) with name, message, animation  
- Built-in **BottomSheet dialogs** for better UX  

---

## 🎨 UI/UX  

- Material Design BottomSheet dialogs  
- Lottie animations (`.raw` resources) for each permission  
- Customizable icons & messages  

---

## 🎥 Demo  

Here’s how it looks in action 👇  

| Camera Permission | Multiple Permissions | Device Admin Access |
|-------------------|----------------------|----------------------|
| ![Camera Demo](screenshots/camera.png) | ![Multi Permission Demo](screenshots/multiple.png) | ![Device Admin Demo](screenshots/admin.png) |

👉 Place your GIFs or screenshots inside the `screenshots/` folder in the repo.  

---

## 🤝 Contributing  

Pull requests are welcome! If you find any bug or missing permission, open an issue or create a PR.  

---

## 📜 License  

This library is released under the **MIT License**.  
