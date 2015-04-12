# SCU-Grad-Assistant-Android-App
Mobile app to to assist new Graduate students of SCU by providing helpful information

As per your Android SDK version, set minSDKVersion and targetSDKVersion in AndroidManifest.xml to make code compatible to run on device:
uses-sdk
        android:minSdkVersion="11"
        android:targetSdkVersion="19" 
        
Database implementaion:
Internal databse: SQLite
External Database: Relational daatabse storage on cloud in parse.com server (Check OnCampusHousingListActivity.java file in src folder)
