# 🚀 CareerForge (Resume Builder Backend API)

[![Java Version](https://img.shields.io/badge/Java-21-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot Version](https://img.shields.io/badge/Spring%20Boot-4.0.2-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Database](https://img.shields.io/badge/Database-MongoDB-green.svg)](https://www.mongodb.com/)
[![Uploads](https://img.shields.io/badge/Uploads-Cloudinary-blue.svg)](https://cloudinary.com/)
[![Payments](https://img.shields.io/badge/Payments-Razorpay-darkviolet.svg)](https://razorpay.com/)
[![Mail](https://img.shields.io/badge/Mail-Brevo%20SMTP-cyan.svg)](https://www.brevo.com/)

A production-ready, highly modular REST API service that powers **CareerForge**, a modern resume builder platform. Engineered using **Spring Boot 4.0.2** and **Java 21**, the system provides robust user administration, dynamic resume curation, cloud media uploads, Brevo-backed mail notifications, and online premium subscriptions verified via Razorpay signatures.

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
resume-builder-backend/
├── src/main/java/com/sagar/resume/
│   ├── Config/              # Third-party service setups (Cloudinary, Mongo, Security chains)
│   ├── Controller/          # REST Endpoint Controllers executing request mappings
│   ├── Document/            # MongoDB schema document mappings (Entities)
│   ├── Dto/                 # Serialization/Deserialization request and response models
│   ├── Exception/           # Centralized global exception handlers
│   ├── Repository/          # MongoRepository data interface layer
│   ├── Security/            # Custom JWT security filters and entry-point filters
│   ├── Service/             # Core business logic execution layers
│   ├── Util/                # Helper tools, JWT parsing engines, and constant parameters
│   └── ResumeBuilderApplication.java  # Main bootstrap application entry point
├── pom.xml                  # Maven Dependency and Plugin definitions
├── Dockerfile               # Blueprint for building containerized docker images
└── README.md                # System documentation
```

### 🔗 Quick File Access Links
*   **Application Configs:** [CloudinaryConfig.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Config/CloudinaryConfig.java) | [MongoConfig.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Config/MongoConfig.java) | [SecurityConfig.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Config/SecurityConfig.java)
*   **REST Controllers:** [AuthController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/AuthController.java) | [EmailController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/EmailController.java) | [PaymentController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/PaymentController.java) | [ResumeController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/ResumeController.java) | [TemplateController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/TemplateController.java)
*   **Core Entities:** [User.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Document/User.java) | [Resume.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Document/Resume.java) | [Payment.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Document/Payment.java)
*   **Business Logic Services:** [AuthService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/AuthService.java) | [ResumeService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/ResumeService.java) | [PaymentService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/PaymentService.java) | [EmailService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/EmailService.java) | [FileUploadService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/FileUploadService.java) | [TemplateService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/TemplateService.java)
*   **Data Models (DTOs):** [LoginRequest.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Dto/LoginRequest.java) | [RegisterRequest.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Dto/RegisterRequest.java) | [AuthResponse.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Dto/AuthResponse.java) | [CreateResumeRequest.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Dto/CreateResumeRequest.java)
*   **Project Configs:** [pom.xml](file:///C:/Users/Sagar/Downloads/resume-builder-backend/pom.xml) | [Dockerfile](file:///C:/Users/Sagar/Downloads/resume-builder-backend/Dockerfile)

---

## 🛠️ Package Breakdown & Class Design

| Package | Key Source Files | Primary Responsibilities |
| :--- | :--- | :--- |
| **`Config`** | [SecurityConfig.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Config/SecurityConfig.java)<br>[CloudinaryConfig.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Config/CloudinaryConfig.java)<br>[MongoConfig.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Config/MongoConfig.java) | Registers beans for CORS mappings, cryptographic password encoders, JWT authentications, Cloudinary SDK client parameters, and NoSQL connection factories. |
| **`Controller`** | [AuthController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/AuthController.java)<br>[ResumeController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/ResumeController.java)<br>[PaymentController.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Controller/PaymentController.java) | Maps HTTP verb routing parameters to backend operations. Exposes endpoints for managing profiles, CV data collections, and invoice records. |
| **`Document`** | [User.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Document/User.java)<br>[Resume.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Document/Resume.java)<br>[Payment.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Document/Payment.java) | MongoDB `@Document` mapped database collections. Includes nested models for professional work history, educational certificates, and skill listings. |
| **`Service`** | [AuthService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/AuthService.java)<br>[ResumeService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/ResumeService.java)<br>[PaymentService.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Service/PaymentService.java) | Implements core business logic. Validates users, updates resume layouts, handles file transfers to Cloudinary, and triggers Brevo emails. |
| **`Security`** | [JwtAuthenticationFilter.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Security/JwtAuthenticationFilter.java) | Filters incoming API queries. Reads bearer authorization headers, resolves JWT validity, and maps verified context variables to Spring Security context. |
| **`Util`** | [JwtUtil.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Util/JwtUtil.java)<br>[AppConstants.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Util/AppConstants.java) | Provides cryptographic signing functions, claim decoders, token generators, and global system default variables. |
| **`Exception`** | [GlobalExceptionHandler.java](file:///C:/Users/Sagar/Downloads/resume-builder-backend/src/main/java/com/sagar/resume/Exception/GlobalExceptionHandler.java) | A `@RestControllerAdvice` controller that intercepts server errors, custom resource validation exceptions, and returns clean, uniform HTTP error payloads. |

---

## 🔒 Environment Variable Configuration

The application reads configurations from environmental properties or `.env` files. Ensure the following variables are configured before bootstrapping:

| Parameter Key | Purpose | Example Value |
| :--- | :--- | :--- |
| **`MONGO_URI`** | Absolute connection string pointing to the MongoDB instance | `mongodb://localhost:27017/resumeBuilder` |
| **`JWT_SECRET`** | High-entropy signature key used for hashing JWT tokens | `YourSuperSecretHMACKeyWhichHasAtLeast256BitsOfEntropy` |
| **`CLOUDINARY_CLOUD_NAME`** | Target folder identifier for Cloudinary assets | `my-resume-cloud` |
| **`CLOUDINARY_API_KEY`** | Access key ID for Cloudinary credentials | `123456789012345` |
| **`CLOUDINARY_API_SECRET`** | Access secret key for Cloudinary integrations | `xxxxxxxxxxxxxxxxxxxxxxxxxxx` |
| **`RAZORPAY_KEY_ID`** | Public key identifier for Razorpay gateway integration | `rzp_test_xxxxxx` |
| **`RAZORPAY_KEY_SECRET`** | Secret cryptographic key for checking Razorpay transactions | `yyyyyyYYYYYYyyyyyy` |
| **`BREVO_SMTP_HOST`** | Host address of SMTP server for Brevo | `smtp-relay.brevo.com` |
| **`BREVO_SMTP_USERNAME`** | Brevo account username / email identifier | `user@server.com` |
| **`BREVO_SMTP_PASSWORD`** | Brevo SMTP authorization password / API key | `xsmtpsib-xxxxxxxxxxxxxxxxxxxx` |
| **`BREVO_SMTP_FROM_EMAIL`** | Sender email address attached to outgoing notifications | `no-reply@careerforge.com` |

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
    git clone https://github.com/Sagar-devx/resume-builder-backend.git
    cd resume-builder-backend
    ```

2.  **Configure local properties:**
    Create an `application.properties` under `src/main/resources/` or set the environment variables in your run configuration.

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
      -e MONGO_URI="mongodb://host.docker.internal:27017/resumeBuilder" \
      -e JWT_SECRET="your-key" \
      careerforge-backend:latest
    ```
