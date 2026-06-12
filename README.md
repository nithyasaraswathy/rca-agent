# AI-Powered Root Cause Analysis (RCA) Agent

## Overview

AI-Powered Root Cause Analysis (RCA) Agent is a Spring Boot application that leverages Google's Gemini Large Language Model (LLM) and LangChain4j to automate incident analysis for production support teams.

The application accepts incident descriptions through a REST API and uses an LLM-driven workflow to identify the issue category, determine the probable root cause, and recommend corrective actions.

Unlike traditional rule-based systems, the control flow is dynamically determined by the LLM, which decides when to invoke specialized tools during incident analysis.

---

## Problem Statement

Production support teams often spend significant time investigating incidents by:

* Reviewing logs
* Searching historical incidents
* Identifying root causes
* Recommending fixes

This project automates the initial RCA process using AI, reducing investigation time and improving incident response efficiency.

---

## Architecture

```text
+--------------------+
|  REST API Request  |
+---------+----------+
          |
          v
+--------------------+
| IncidentController |
+---------+----------+
          |
          v
+--------------------+
|   IncidentAgent    |
| (Gemini + LLM)     |
+---------+----------+
          |
          v
+--------------------+
|  LangChain4j Agent |
+---------+----------+
          |
          |
   +------+------+
   |             |
   v             v
+---------+  +------------------+
| Log     |  | Knowledge Base   |
| Analysis|  | Tool             |
| Tool    |  |                  |
+---------+  +------------------+
          |
          v
+--------------------+
| RCA Response       |
+--------------------+
```

---

## Tech Stack

* Java 17
* Spring Boot
* Gradle
* LangChain4j
* Google Gemini 2.5 Flash
* Docker
* REST API

---

## LLM-Driven Control Flow

In this projcect,the control flow within the agent application should be decided by LLM.

> "The control flow within the agent application should be decided by LLM."

The Gemini LLM determines:

1. Whether log analysis is required.
2. Whether historical incident lookup is required.
3. Which tool should be invoked.
4. How tool responses should be combined.
5. Final RCA generation.

Example:

Input:

```text
Orders API returning 500 errors
```

LLM Decision Flow:

```text
Analyze Incident
      |
      v
Call LogAnalysisTool
      |
      v
Call KnowledgeBaseTool
      |
      v
Generate RCA
```

The application does not hardcode the execution sequence.

---

## Tools

### LogAnalysisTool

Purpose:

Analyzes incident descriptions and identifies known error patterns.

Example:

```text
Input:
Orders API returning 500 errors

Output:
Potential application failure or database timeout.
```

---

### KnowledgeBaseTool

Purpose:

Retrieves information from historical incidents.

Example:

```text
Similar Incident #INC32101

Issue caused by database timeout,
resolved by increasing connection pool size.
```

---

## API Endpoint

### Analyze Incident

POST

```http
http://localhost:8080/incidents/analyze
```

Request:

```json
{
  "incidentDescription": "Orders API returning 500 errors"
}
```

Response:

```text
Issue Category: Application Error / Database Connectivity

Root Cause:
Database Timeout

Recommended Fix:
Increase the database connection pool size.
```

---

## Configuration

Application uses environment variables for secure credential management.

application.yml

```yaml
gemini:
  api-key: ${GEMINI_API_KEY}
```

Set environment variable:

Mac

```bash
export GEMINI_API_KEY=<YOUR_GEMINI_API_KEY>
```

---

## Running Locally

Build Project

```bash
./gradlew clean build
```

Run Application

```bash
./gradlew bootRun
```

Application starts on:

```text
http://localhost:8080
```

---

## Docker Support

Build Docker Image

```bash
docker build -tag rca-agent .
```

Run Container

```bash
docker run -e GEMINI_API_KEY=$GEMINI_API_KEY -p 8080:8080 rca-agent
```

---

## Project Structure

```text
src
 └── main
     ├── java
     │   └── org.example.rcaagent
     │       ├── agent
     │       ├── config
     │       ├── controller
     │       ├── model
     │       └── tools
     └── resources
         └── application.yml
```

---


## Author

Nithya S

AI-Powered Root Cause Analysis Agent

Spring Boot | LangChain4j | Gemini | Docker
