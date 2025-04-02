# A local Iddir App

|Group Name| Id no|
|:---------|:-----|
|Biruk Dereje|UGR/6190/15|
|Kalafat Tezazu|UGR/6048/15|
|Samrawit Alemzewd|UGR/9726/15|
|Yonas Degefu|UGR/6959/15|
|Yusra Yakutelarsh|UGR/6201/13|


# Mobile Iddir App

## Description

The Mobile Iddir App is a community-based mobile application designed to help our local communities manage their mutual aid societies (Iddirs). The app provides an efficient platform for managing subscriptions, payments, and emergency support requests among members of the Iddir. It is designed to work locally, meaning the entire app and its data will be stored and managed on the user’s device, ensuring the app works without needing any internet connection or external cloud services.

The app will store all user and transaction data on the local device, and it will allow members to interact with the app seamlessly without requiring an online connection.

## Features

### 1. Subscription Management and Payment System
   - User Registration and Profile Creation: Users can register, create profiles, and join an Iddir.
   - Subscription Payment: Members can contribute regularly to the Iddir using various methods, including local payment tracking (e.g., cash payments, SMS-based reminders).
   - Automatic Payment Reminders: The app will send notifications about upcoming subscription dues based on user input, ensuring timely payments.
   - Payment History: Users can view their payment history stored locally on the device.

### 2. Emergency Support and Request System
   - Request for Assistance: Members can request emergency support (e.g., funeral assistance, medical support, etc.). The app allows users to submit a request with details such as the nature of the emergency and the amount of support required. All information will be stored locally.
   - Community Contributions: Other members of the Iddir can contribute additional funds to support emergency requests. Contributions are stored and tracked locally.
   - Approval and Coordination: The Iddir administrators can approve or deny requests, and they can manage the allocation of funds and other resources.
   - Notifications: The app will notify members when a support request is made, when contributions are collected, and when resources are distributed.

### 3. Admin Dashboard (Offline)
   - User Management: Admins can view and manage members, including their profiles, payment history, and participation in emergency support. All this data is stored on the device.
   - Transaction History: Admins can view detailed logs of all transactions, including incoming payments and distributions for emergency support, stored locally on the device.
   - Fundraising Events: Admins can create special fundraising events for larger emergencies, allowing the community to contribute to a pooled fund for more significant causes.

## Technologies Used

- Frontend: Jetpack Compose (Kotlin) - For building the UI and handling app layout and interactions in a native Android environment.
- Local Storage: 
  - Room Database: Used for storing user profiles, payment history, and support requests locally on the device.
  - SharedPreferences: For storing smaller configuration settings, such as subscription reminders and basic user preferences.
- Local Notifications: Used for sending reminders for payments and support requests without needing an internet connection.
- Offline Data Sync: (Optional) If desired, the app can include functionality for syncing data with a server when an internet connection becomes available, but this is optional and not required for basic operation.
