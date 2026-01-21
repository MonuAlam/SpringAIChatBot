# 🚀 AI ChatBot - Complete Setup Guide

Full-stack AI ChatBot with Spring Boot + React + Groq API

---

## 📁 Project Structure

```
SpringAIChatBot/
├── src/                          # Backend (Spring Boot)
│   ├── main/java/com/aichatbot/
│   │   ├── controller/          # REST API
│   │   ├── service/             # Business Logic
│   │   ├── dto/                 # Request/Response DTOs
│   │   ├── client/              # ChatClient (Fluent API)
│   │   ├── config/              # Configuration (CORS, ChatModel)
│   │   └── exception/           # Error Handling
│   └── main/resources/
│       └── application.properties
├── chatbot-frontend/            # Frontend (React + Elastic UI)
│   ├── src/
│   │   ├── components/
│   │   │   └── ChatBox.jsx     # Main Chat UI
│   │   ├── services/
│   │   │   └── api.js          # API Integration
│   │   ├── App.jsx
│   │   └── main.jsx
│   └── package.json
└── pom.xml
```

---

## 🛠️ Backend Setup (Spring Boot)

### 1. Prerequisites
- Java 17+
- Maven 3.6+
- Groq API Key (Free at https://console.groq.com)

### 2. Configure API Key

Edit `src/main/resources/application.properties`:
```properties
spring.ai.openai.api-key=YOUR_GROQ_API_KEY
spring.ai.openai.base-url=https://api.groq.com/openai
spring.ai.openai.chat.options.model=llama-3.3-70b-versatile
```

### 3. Build & Run

```bash
# Compile
mvn clean compile

# Run backend
mvn spring-boot:run
```

Backend will start at: **http://localhost:8080**

### 4. Test Backend

```bash
# Test with curl
curl -X POST http://localhost:8080/api/chat \
  -H "Content-Type: application/json" \
  -d '{"message":"Hello"}'
```

---

## 💻 Frontend Setup (React + Custom CSS)

### 1. Install Dependencies (Simplified - No Elastic UI)

```bash
cd chatbot-frontend

# Clean npm cache if you had previous errors
npm cache clean --force

# Install dependencies (only react, react-dom, axios)
npm install
```

### 2. Start Dev Server

```bash
npm run dev
```

Frontend will start at: **http://localhost:5173**

---

## 🎯 Running the Complete Application

### Terminal 1 - Backend
```bash
cd SpringAIChatBot
mvn spring-boot:run
```

### Terminal 2 - Frontend
```bash
cd SpringAIChatBot/chatbot-frontend
npm run dev
```

### Access the App
Open browser: **http://localhost:5173**

---

## ✨ Features

### Backend
- ✅ Spring Boot 3.5.9 + Java 17
- ✅ Clean Architecture (Controller → Service → Client → API)
- ✅ Lombok for clean code
- ✅ Request/Response DTOs
- ✅ Global Exception Handling
- ✅ CORS Configuration
- ✅ Logging with SLF4J
- ✅ Groq API Integration (Free, Fast, Unlimited)
- ✅ LLaMA 3.3 70B Model

### Frontend
- ✅ React 18 + Vite
- ✅ Beautiful Custom CSS (Gradient Design)
- ✅ Modern Chat Interface
- ✅ Real-time messaging
- ✅ Auto-scroll to latest messages
- ✅ Loading indicators
- ✅ Error handling
- ✅ Responsive design
- ✅ Message timestamps
- ✅ Model badges

---

## 📝 API Endpoints

### POST /api/chat
**Request:**
```json
{
  "message": "What is Spring Boot?"
}
```

**Response:**
```json
{
  "response": "Spring Boot is a framework...",
  "model": "llama-3.3-70b-versatile",
  "timestamp": 1768920930237
}
```

### GET /api/chat?message=hello
Query parameter alternative to POST

---

## 🎨 Technologies Used

### Backend Stack
- Spring Boot 3.5.9
- Spring AI 1.1.2
- Lombok
- Maven
- Groq API (OpenAI-compatible)

### Frontend Stack
- React 18.2.0
- Vite 7.2.4
- Axios 1.6.5
- Custom CSS (No UI Library Dependencies)

---

## 🔧 Troubleshooting

### Backend Issues

**Port 8080 already in use:**
```bash
lsof -i :8080
kill -9 <PID>
```

**Groq API errors:**
- Check API key in application.properties
- Ensure model name is correct: `llama-3.3-70b-versatile`
- Verify internet connection

### Frontend Issues

**Port 5173 already in use:**
Vite will auto-select next available port

**CORS errors:**
- Ensure backend is running
- Check WebConfig.java has correct origins

**npm install fails:**
```bash
sudo chown -R $(whoami) ~/.npm
rm -rf node_modules package-lock.json
npm install
```

---

## 📦 Build for Production

### Backend
```bash
mvn clean package
java -jar target/SpringAIChatBot-0.0.1-SNAPSHOT.jar
```

### Frontend
```bash
cd chatbot-frontend
npm run build
# Output in dist/ folder
```

---

## 🚀 Quick Start (One-liner)

```bash
# Terminal 1 - Backend
mvn spring-boot:run

# Terminal 2 - Frontend (in new terminal)
cd chatbot-frontend && npm install && npm run dev
```

---

## 📸 Screenshots

The application features:
- 💬 Clean chat interface with Elastic UI
- 👤 User messages on the right
- 🤖 AI responses on the left with model badges
- ⏰ Timestamps for all messages
- 🔄 Loading spinner while AI thinks
- 🎯 Error handling with user-friendly messages

---

## 🤝 Support

For issues or questions:
1. Check the troubleshooting section
2. Verify all prerequisites are installed
3. Ensure both backend and frontend are running

Happy Chatting! 🎉
