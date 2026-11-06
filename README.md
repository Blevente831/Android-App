# 🏠 Smart Home Android App

A full-stack smart home application that lets users **manage their devices**, **analyze energy and usage patterns**, and receive **AI-generated automation suggestions**. The Android client is built with Kotlin and Jetpack Compose, backed by a Node.js/Express server running on Google Cloud Run.

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?logo=jetpackcompose&logoColor=white)
![Node.js](https://img.shields.io/badge/Node.js-339933?logo=nodedotjs&logoColor=white)
![Express](https://img.shields.io/badge/Express.js-000000?logo=express&logoColor=white)
![Firestore](https://img.shields.io/badge/Firestore-FFCA28?logo=firebase&logoColor=black)
![Google Cloud](https://img.shields.io/badge/Google%20Cloud-4285F4?logo=googlecloud&logoColor=white)
![JWT](https://img.shields.io/badge/Auth-JWT-000000?logo=jsonwebtokens&logoColor=white)

---

## ✨ Features

- **Device management**: add, view, edit, and control smart devices (e.g. thermostats) from one place.
- **Usage analysis**: track how devices are used and review the data on a dashboard.
- **AI-generated suggestions**: Google's Vertex AI language model analyzes usage and proposes automation ideas.
- **Secure authentication**: registration and login with JSON Web Tokens (JWT).
- **User profile and settings**: manage account details and app preferences.
- **Cloud-native backend**: stateless API deployed on Cloud Run, with data in Firestore and files in Cloud Storage.

---

## 📱 Screenshots
| Login | Registration | 


<img width="250" height="516" alt="Screenshot 2025-06-17 222458" src="https://github.com/user-attachments/assets/43a63535-d03b-42c4-be4f-2ef534a8a36b" /><img width="260" height="545" alt="Screenshot 2025-06-17 204504" src="https://github.com/user-attachments/assets/910e2054-ff64-482a-87ea-a8d31e7a0059" />





Dashboard page Device List page

<img width="258" height="536" alt="Screenshot 2025-06-18 153412" src="https://github.com/user-attachments/assets/7f66849c-125c-4088-b689-d02cc9dfb69b" /><img width="256" height="540" alt="Screenshot 2025-06-18 174842" src="https://github.com/user-attachments/assets/ec5ad19e-1b2a-4041-bb2b-bcbe9d60fd82" />


Device control page(thermostat) and AI suggestions section

<img width="256" height="534" alt="Screenshot 2025-06-18 174928" src="https://github.com/user-attachments/assets/b7e0118b-b7aa-4bc5-9146-071d2ce13f84" /><img width="253" height="536" alt="Screenshot 2025-06-26 212736" src="https://github.com/user-attachments/assets/ece5b0b9-1678-4f87-8379-b6de72f856b2" />

Add device page

<img width="264" height="547" alt="Screenshot 2025-06-26 173550" src="https://github.com/user-attachments/assets/22e4cb25-cd0b-4705-8d47-0ab7662da368" /><img width="262" height="542" alt="Screenshot 2025-06-26 173644" src="https://github.com/user-attachments/assets/19b34fbc-21e2-4617-af8d-cc0b08b0cab0" />

Settings page   Profile page


<img width="264" height="536" alt="Screenshot 2025-06-27 125001" src="https://github.com/user-attachments/assets/247d49eb-b458-45a4-a4ce-b34247e07b2c" /><img width="255" height="526" alt="Screenshot 2025-06-27 140810" src="https://github.com/user-attachments/assets/22b667ba-ac32-4ebb-9151-858a94e52ea2" />

---

## 🏗️ Architecture

```
┌────────────────────┐        HTTPS + JWT        ┌─────────────────────────┐
│   Android App      │ ────────────────────────▶ │  Node.js / Express API  │
│ Kotlin + Compose   │ ◀──────────────────────── │     (Google Cloud Run)  │
└────────────────────┘                           └───────────┬─────────────┘
                                                             │
                          ┌──────────────────────────────────┼──────────────────────────┐
                          ▼                                  ▼                          ▼
                 ┌─────────────────┐              ┌───────────────────┐       ┌──────────────────┐
                 │   Firestore     │              │  Cloud Storage    │       │    Vertex AI     │
                 │ (device data)   │              │     (files)       │       │ (LLM suggestions)│
                 └─────────────────┘              └───────────────────┘       └──────────────────┘
```

**Request flow:** the app authenticates the user and receives a JWT. Each later request carries the token, the Express server verifies it, reads or writes data in Firestore and Cloud Storage, and for suggestions sends usage data to Vertex AI and returns the generated recommendations.

---

## 🧰 Tech Stack

| Layer | Technology |
|---|---|
| **Mobile client** | Android Studio, Kotlin, Jetpack Compose |
| **Backend** | Node.js, Express.js |
| **Authentication** | JSON Web Token (JWT) |
| **Database** | Google Cloud Firestore |
| **File storage** | Google Cloud Storage |
| **AI** | Google Vertex AI (language model) |
| **Hosting** | Google Cloud Run |

---

## 📂 Project Structure

```
Android-App/
├── android/     # Android client (Kotlin + Jetpack Compose)
├── backend/     # Node.js + Express.js API
└── README.md
```

---

## 🚀 Getting Started

### Prerequisites

- [Android Studio](https://developer.android.com/studio) (latest stable)
- [Node.js](https://nodejs.org/) 18+ and npm
- A Google Cloud project with **Firestore**, **Cloud Storage**, **Vertex AI**, and **Cloud Run** enabled
- [Google Cloud CLI](https://cloud.google.com/sdk/docs/install) (`gcloud`)

### 1. Clone the repository

```bash
git clone https://github.com/Blevente831/Android-App.git
cd Android-App
```

### 2. Run the backend

```bash
cd backend
npm install
```

Create a `.env` file in `backend/` (adjust names to match your code):

```env
PORT=8080
JWT_SECRET=your_long_random_secret
GCP_PROJECT_ID=your-gcp-project-id
GCS_BUCKET_NAME=your-storage-bucket
VERTEX_AI_LOCATION=us-central1
```

Authenticate locally with Google Cloud, then start the server:

```bash
gcloud auth application-default login
npm start
```

The API will be available at `http://localhost:8080`.

### 3. Run the Android app

1. Open the `android/` folder in **Android Studio**.
2. Let Gradle sync finish.
3. Set the backend base URL in the app's configuration:
   - Android emulator → `http://10.0.2.2:8080`
   - Deployed backend → your Cloud Run URL
4. Select an emulator or a physical device and press **Run ▶**.

---

## ☁️ Deployment (Cloud Run)

From the `backend/` directory:

```bash
gcloud run deploy smart-home-api \
  --source . \
  --region <your-region> \
  --allow-unauthenticated \
  --set-env-vars JWT_SECRET=<secret>,GCP_PROJECT_ID=<project-id>,GCS_BUCKET_NAME=<bucket>
```

> 🔐 For production, store secrets in **Secret Manager** rather than plain environment variables, and grant the Cloud Run service account only the IAM roles it needs (Firestore, Storage, Vertex AI).

---

## 🔒 Security Notes

- Passwords should be hashed (e.g. with bcrypt) before storage.
- JWTs are verified by middleware on all protected routes.
- Never commit `.env` files or service account keys. Make sure they are listed in `.gitignore`.

---

## 🗺️ Roadmap

- [ ] Support for more device types (lights, plugs, sensors)
- [ ] Scheduled automations based on accepted AI suggestions
- [ ] Push notifications for unusual usage
- [ ] Charts and long-term usage history
- [ ] Unit and integration tests, plus CI/CD

---

## 👤 Author

**Levente Barna**
[LinkedIn](https://www.linkedin.com/in/levente-barna-773b4a243/) · [GitHub](https://github.com/Blevente831)

---

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for details, or choose the license that fits your needs.
