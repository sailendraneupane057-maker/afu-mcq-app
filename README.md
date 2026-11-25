# AFU Forestry MCQ – Android app

Offline Android version of the AFU M.Sc. Forestry entrance MCQ trainer
(1,197 MCQs, Study / Practice / Model mock tests). Everything is bundled in
`app/src/main/assets/index.html`; no internet permission is needed.

## Download
Latest APK: https://github.com/sailendraneupane057-maker/afu-mcq-app/releases/latest/download/AFU-Forestry-MCQ.apk

## Option A – Build on GitHub (no software needed)
1. Create a new repository on github.com (e.g. `afu-mcq-app`).
2. Upload all files in this folder (keep the folder structure, including `.github`).
3. Open the **Actions** tab → the "Build APK" workflow runs automatically (~4 min).
4. Open the finished run → download **AFU-Forestry-MCQ-apk** → unzip → `app-release.apk`.

## Option B – Android Studio
1. File → Open → select this folder. Let Gradle sync finish.
2. Build → Build App Bundle(s) / APK(s) → Build APK(s).
3. The APK appears in `app/build/outputs/apk/`.

## Install on your phone
Copy the APK to the phone, open it, and allow "Install unknown apps" for your file manager when asked.

Package: `com.naturecrest.afumcq` · minSdk 21 (Android 5.0+) · targetSdk 34.
