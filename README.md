# 🚀 CareerForge (Resume Builder Backend API)

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Database](https://img.shields.io/badge/Database-MongoDB-green.svg)](https://www.mongodb.com/)
[![Uploads](https://img.shields.io/badge/Uploads-Cloudinary-blue.svg)](https://cloudinary.com/)
[![Payments](https://img.shields.io/badge/Payments-Razorpay-darkviolet.svg)](https://razorpay.com/)
[![Mail](https://img.shields.io/badge/Mail-Brevo%20SMTP-cyan.svg)](https://www.brevo.com/)
[![API Docs](https://img.shields.io/badge/API%20Docs-Swagger%20UI-red.svg)](https://swagger.io/)

A production-ready, highly modular REST API service that powers **CareerForge**, a modern resume builder platform. Engineered using **Spring Boot 4.0.2** and **Java 21**, the system provides robust user administration, dynamic resume curation, cloud media uploads, Brevo-backed mail notifications, and online premium subscriptions verified via Razorpay signatures.

---

## 🌐 Live Interactive API Documentation

*   **Interactive API Docs (Swagger UI):** [https://careerforge-backend-z4sg.onrender.com](https://careerforge-backend-z4sg.onrender.com) 🚀 *(Clicking this live URL will automatically redirect HR, recruiters, and developers to the interactive Swagger UI to test all endpoints live)*

---

## 🌟 Key Features

*   🔐 **JWT-Protected Stateless Authentication:** Restricts resume management endpoints behind custom JWT filters using Spring Security. Handles email verification and password hashing.
*   📝 **Resume Generation Engine:** Detailed JSON schema representation of user CVs, including education histories, professional work experiences, project portfolios, technical skills, languages, and custom templates.
*   🌥️ **Cloud-Backed Media Management:** Integrates Cloudinary API for secure profile image uploading and rendering.
*   💳 **Razorpay Order & Signature Validation:** Facilitates premium upgrades. Automates order generation and verifies webhook signatures for subscription payments.
*   ✉️ **Automated Brevo SMTP Integration:** Dispatches verification emails, registration confirmations, and supports sharing resumes with external employers via email.
*   📊 **Operational Diagnostics:** Integrates Spring Actuator endpoints to monitor database health and application performance metrics.

---

## 📂 Architecture & Directory Layout

```text
careerforge-backend/
├── src/main/java/com/sagar/resume/
│   ├── config/              # Third-party service setups (Cloudinary, Mongo, Security chains)
│   ├── controller/          # REST Endpoint Controllers executing request mappings
│   ├── document/            # MongoDB schema document mappings (Entities)
│   ├── dto/                 # Serialization/Deserialization request and response models
│   ├── exception/           # Centralized global exception handlers
│   ├── repository/          # MongoRepository data interface layer
│   ├── security/            # Custom JWT security filters and entry-point filters
│   ├── service/             # Core business logic execution layers
│   ├── util/                # Helper tools, JWT parsing engines, and constant parameters
│   └── ResumeBuilderApplication.java  # Main bootstrap application entry point
├── pom.xml                  # Maven Dependency and Plugin definitions
├── Dockerfile               # Blueprint for building containerized docker images
└── README.md                # System documentation
```

### 🔗 Quick File Access Links
*   **Application Configs:** [CloudinaryConfig.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/config/CloudinaryConfig.java) | [MongoConfig.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/config/MongoConfig.java) | [SecurityConfig.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/config/SecurityConfig.java)
*   **REST Controllers:** [AuthController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/AuthController.java) | [EmailController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/EmailController.java) | [PaymentController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/PaymentController.java) | [ResumeController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/ResumeController.java) | [TemplateController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/TemplateController.java)
*   **Core Entities:** [User.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/document/User.java) | [Resume.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/document/Resume.java) | [Payment.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/document/Payment.java)
*   **Business Logic Services:** [AuthService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/AuthService.java) | [ResumeService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/ResumeService.java) | [PaymentService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/PaymentService.java) | [EmailService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/EmailService.java) | [FileUploadService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/FileUploadService.java) | [TemplateService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/TemplateService.java)
*   **Data Models (DTOs):** [LoginRequest.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/dto/LoginRequest.java) | [RegisterRequest.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/dto/RegisterRequest.java) | [AuthResponse.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/dto/AuthResponse.java) | [CreateResumeRequest.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/dto/CreateResumeRequest.java)
*   **Project Configs:** [pom.xml](file:///C:/Users/Sagar/Downloads/careerforge-backend/pom.xml) | [Dockerfile](file:///C:/Users/Sagar/Downloads/careerforge-backend/Dockerfile)

---

## 🛠️ Package Breakdown & Class Design

| Package | Key Source Files | Primary Responsibilities |
| :--- | :--- | :--- |
| **`config`** | [SecurityConfig.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/config/SecurityConfig.java)<br>[CloudinaryConfig.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/config/CloudinaryConfig.java)<br>[MongoConfig.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/config/MongoConfig.java) | Registers beans for CORS mappings, cryptographic password encoders, JWT authentications, Cloudinary SDK client parameters, and NoSQL connection factories. |
| **`controller`** | [AuthController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/AuthController.java)<br>[ResumeController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/ResumeController.java)<br>[PaymentController.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/controller/PaymentController.java) | Maps HTTP verb routing parameters to backend operations. Exposes endpoints for managing profiles, CV data collections, and invoice records. |
| **`document`** | [User.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/document/User.java)<br>[Resume.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/document/Resume.java)<br>[Payment.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/document/Payment.java) | MongoDB `@Document` mapped database collections. Includes nested models for professional work history, educational certificates, and skill listings. |
| **`service`** | [AuthService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/AuthService.java)<br>[ResumeService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/ResumeService.java)<br>[PaymentService.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/service/PaymentService.java) | Implements core business logic. Validates users, updates resume layouts, handles file transfers to Cloudinary, and triggers Brevo emails. |
| **`security`** | [JwtAuthenticationFilter.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/security/JwtAuthenticationFilter.java) | Filters incoming API queries. Reads bearer authorization headers, resolves JWT validity, and maps verified context variables to Spring Security context. |
| **`util`** | [JwtUtil.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/util/JwtUtil.java)<br>[AppConstants.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/util/AppConstants.java) | Provides cryptographic signing functions, claim decoders, token generators, and global system default variables. |
| **`exception`** | [GlobalExceptionHandler.java](file:///C:/Users/Sagar/Downloads/careerforge-backend/src/main/java/com/sagar/resume/exception/GlobalExceptionHandler.java) | A `@RestControllerAdvice` controller that intercepts server errors, custom resource validation exceptions, and returns clean, uniform HTTP error payloads. |

---

## 🔒 Environment Variable Configuration

The application reads configurations from environmental properties or Render's configuration dashboard. Make sure the following keys are set:

| Environment Variable Key | Purpose | Example Value |
| :--- | :--- | :--- |
| **`SPRING_MONGODB_URI`** | Absolute connection string pointing to the MongoDB Atlas or local instance | `mongodb+srv://user:pass@cluster.mongodb.net/dbname` |
| **`JWT_SECRET`** | High-entropy signature key used for hashing JWT tokens | `YourSuperSecretHMACKeyWhichHasAtLeast256BitsOfEntropy` |
| **`JWT_EXPIRATION`** | JWT token lifespan in milliseconds | `604800000` |
| **`CLOUDINARY_CLOUD_NAME`**| Target cloud identifier for Cloudinary assets | `my-resume-cloud` |
| **`CLOUDINARY_API_KEY`** | Access key ID for Cloudinary credentials | `123456789012345` |
| **`CLOUDINARY_API_SECRET`** | Access secret key for Cloudinary integrations | `xxxxxxxxxxxxxxxxxxxxxxxxxxx` |
| **`RAZORPAY_KEY_ID`** | Public key identifier for Razorpay gateway integration | `rzp_test_xxxxxx` |
| **`RAZORPAY_KEY_SECRET`** | Secret cryptographic key for checking Razorpay transactions | `yyyyyyYYYYYYyyyyyy` |
| **`SPRING_MAIL_HOST`** | Host address of SMTP server (e.g., Brevo) | `smtp-relay.brevo.com` |
| **`SPRING_MAIL_PORT`** | Port address of SMTP server | `587` |
| **`SPRING_MAIL_USERNAME`** | Brevo account username / SMTP email identifier | `user@server.com` |
| **`SPRING_MAIL_PASSWORD`** | Brevo SMTP authorization password / API key | `xsmtpsib-xxxxxxxxxxxxxxxxxxxx` |
| **`SPRING_MAIL_FROM`** | Sender email address attached to outgoing notifications | `no-reply@careerforge.com` |
| **`APP_BASE_URL`** | Base URL of backend application (local or live deployment) | `https://careerforge-backend-wery.onrender.com` |
| **`CORS_ALLOWED_ORIGINS`** | Allowed frontend URL for CORS policy | `http://localhost:5173` |

---

## 📡 Core API Endpoints

### 🔐 User Security Operations (`/api/auth`)
*   `POST /register` - Registers a new profile. Sends a Brevo verification email.
*   `POST /login` - Checks password matching and returns a secure JWT bearer token.
*   `POST /verify-email` - Validates email verification code.
*   `POST /resend-verification` - Refreshes verification code and dispatches a new email.
*   `GET /profile` - Fetches authenticated user info.
*   `POST /upload-image` - Uploads a user's avatar image to Cloudinary.

### 📄 Resume Management (`/api/resumes`)
*   `GET /` - Fetches all resume collections created by the current user.
*   `POST /` - Creates a new resume document.
*   `GET /{id}` - Retrieves a specific resume layout.
*   `PUT /{id}` - Updates a resume's sections (experience, projects, skills).
*   `DELETE /{id}` - Permanently deletes a resume document.
*   `POST /{id}/upload-images` - Handles custom image uploads within the resume.

### 💳 Payment Operations (`/api/payment`)
*   `POST /create-order` - Requests Razorpay order creation for premium access.
*   `POST /verify-payment` - Verifies Razorpay signatures and updates transaction status.
*   `GET /order/{orderId}` - Retrieves details for a specific billing transaction.

### ✉ Email Operations (`/api/email`)
*   `POST /send-resume` - Emails a generated resume layout to target employers.

### 🎨 Template Catalog (`/api/templates`)
*   `GET /` - Lists all styled resume templates available.

---

## 🚀 How to Run the Project

### Prerequisites
*   **Java 21 Development Kit (JDK)** or newer.
*   **Maven 3.8+** (or use the packaged wrapper `./mvnw`).
*   Running **MongoDB** instance (local or Atlas cluster).

### Step-by-Step Launch

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Sagar-devx/careerforge-backend.git
    cd careerforge-backend
    ```

2.  **Configure Environment Variables:**
    Set the environment variables locally or in your IDE run configuration.

3.  **Compile & Package the service:**
    ```bash
    ./mvnw clean install
    ```

4.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will default to running on `http://localhost:8080`.

### Containerized Deployment via Docker

1.  **Build Docker Image:**
    ```bash
    docker build -t careerforge-backend:latest .
    ```

2.  **Run Container:**
    ```bash
    docker run -d -p 8080:8080 --name careerforge-api \
      -e SPRING_MONGODB_URI="mongodb://host.docker.internal:27017/careerforge" \
      -e JWT_SECRET="your-key" \
      careerforge-backend:latest
    ```
