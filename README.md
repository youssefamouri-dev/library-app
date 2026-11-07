# JavaFX Project (starter template)

A ready-to-use JavaFX project for VS Code. It opens a small window where you type your name, click **Say hello**, and a counter goes up.

Use this folder as a **template**: every time you want a new JavaFX project, copy this folder and rename a few things (see [Part 4](#part-4--create-a-new-javafx-project-from-this-template)).

## Quick start: create a new project from this template

**From the terminal** (needs [GitHub CLI](https://cli.github.com), logged in with `gh auth login`):
```
gh repo create library-app --template youssefamouri-dev/javafx-template --public --clone
cd library-app
code .
```
This creates a new GitHub repository `library-app` with a copy of the template, downloads it, and opens it in VS Code. Use `--private` instead of `--public` for a private repo.

**From the website:** open https://github.com/youssefamouri-dev/javafx-template, click **Use this template → Create a new repository**, choose a name, then clone it (`git clone <url>`) or use **Code → Download ZIP**.

**Without GitHub** (just a local copy, no new repo):
```
gh repo clone youssefamouri-dev/javafx-template library-app -- --depth 1
```
Then delete the hidden `.git` folder inside `library-app` so it doesn't stay linked to the template.

After creating the project, rename the project and package as explained in [Part 4](#part-4--create-a-new-javafx-project-from-this-template), from Step 2.

---

## Contents

1. [What's in this folder](#part-1--whats-in-this-folder)
2. [One-time setup of your PC](#part-2--one-time-setup-of-your-pc)
3. [Open and run this project in VS Code](#part-3--open-and-run-this-project-in-vs-code)
4. [Create a new JavaFX project from this template](#part-4--create-a-new-javafx-project-from-this-template)
5. [Write your own code](#part-5--write-your-own-code)
6. [Optional: FXML and Scene Builder](#part-6--optional-fxml-and-scene-builder)
7. [Plain Java (no JavaFX) in any folder](#part-7--plain-java-no-javafx-in-any-folder)
8. [Troubleshooting](#part-8--troubleshooting)

---

## Part 1 – What's in this folder

```
JavaFX Project/
├── build.gradle                  Gradle config: Java version, JavaFX version/modules, main class
├── settings.gradle               the project name
├── gradlew / gradlew.bat         Gradle wrapper: runs Gradle without installing it
├── gradle/wrapper/               files used by the wrapper (don't edit)
├── .gitignore                    files Git should ignore (build output)
└── src/main/
    ├── java/
    │   ├── module-info.java      says which JavaFX modules the program needs
    │   └── app/
    │       └── MainApp.java      the JavaFX app (the class with main)
    └── resources/
        └── app/
            └── style.css         CSS used to style the window
```

Folders created automatically (you can delete them anytime, they come back):
- `build/`: compiled classes
- `.gradle/`: Gradle cache for this project
- `bin/`: compiled classes made by VS Code

**Why Gradle?** JavaFX has not been included in the JDK since Java 11. Instead of downloading the JavaFX SDK by hand and configuring paths, `build.gradle` tells Gradle to **download JavaFX automatically** the first time you run the project. You install nothing extra.

---

## Part 2 – One-time setup of your PC

Do these steps **once per computer**. After that, every Java / JavaFX project works.

### 2.1 Install a JDK (Java Development Kit)

- Installed: **Eclipse Temurin JDK 21** in `C:\Program Files\Eclipse Adoptium\jdk-21.0.13.9-hotspot`
- Install command used (in PowerShell):
  ```
  winget install EclipseAdoptium.Temurin.21.JDK
  ```
  Or download the `.msi` from https://adoptium.net. During the install, enable **"Add to PATH"** and **"Set JAVA_HOME variable"**.
- Check it works by opening a **new** terminal and typing:
  ```
  java -version
  javac -version
  ```
  Both should say `21.0.x`.

### 2.2 Install the VS Code extensions

In VS Code, open the Extensions panel (`Ctrl+Shift+X`) and install:
- **Extension Pack for Java** (Microsoft). It includes Language Support for Java (Red Hat), Debugger, Test Runner, Maven and Project Manager.
- **Gradle for Java** (Microsoft)

### 2.3 Global VS Code settings

Open `Ctrl+Shift+P` → **Preferences: Open User Settings (JSON)**. The Java part looks like this:

```jsonc
"java.jdt.ls.java.home": "C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.13.9-hotspot",
"java.import.gradle.java.home": "C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.13.9-hotspot",
"java.configuration.runtimes": [
    {
        "name": "JavaSE-21",
        "path": "C:\\Program Files\\Eclipse Adoptium\\jdk-21.0.13.9-hotspot",
        "default": true,
    },
],
"[java]": {
    "editor.defaultFormatter": "redhat.java",
},
```

- The first three lines tell VS Code (and Gradle) which JDK to use. They are **global** settings, so they work in **every folder**.
- The `[java]` part makes the Java extension format `.java` files instead of Prettier, which can't format Java.

> If you install a newer JDK later, update the 3 paths above to the new folder.

---

## Part 3 – Open and run this project in VS Code

### Step 1: Open the folder

1. In VS Code: **File → Open Folder...**
2. Select the **`JavaFX Project`** folder itself (not its parent folder).
3. If VS Code asks *"Do you trust the authors?"*, click **Yes, I trust the authors**.

### Step 2: Wait for the import (first time only)

- In the bottom status bar you'll see things like *"Java: Importing projects"* / *"Gradle: Synchronizing"*.
- The **first** time, Gradle downloads JavaFX and the Gradle plugin from the internet, which can take 1 to 3 minutes. After that, it's fast.
- When it's done, the status bar shows a 👍 or `{ }` Java icon, and there are no red errors in `MainApp.java`.

### Step 3: Run the app (choose ONE way)

**Way A: Gradle panel (recommended)**
1. Click the **Gradle icon** (an elephant 🐘) in the left bar.
2. Expand **javafx-project → Tasks → application**.
3. Click the **▶** next to **run**.
4. The window "JavaFX Project" opens.

**Way B: Terminal**
1. Open the terminal: **Terminal → New Terminal** (`` Ctrl+` ``).
2. Type:
   ```
   .\gradlew run
   ```

**Way C: Run button above `main`**
- Open `MainApp.java` and click **Run** (the small text above `public static void main`).
- This usually works because VS Code reads `build.gradle`. If it says *"JavaFX runtime components are missing"*, use Way A or B instead.

> ⚠️ **Do NOT use the ▷ "Run Code" button** in the top-right corner. It comes from the **Code Runner** extension, which compiles the file on its own and doesn't know about JavaFX, so it fails.

### Step 4: Stop the app

Close the window, or press `Ctrl+C` in the terminal.

---

## Part 4 – Create a new JavaFX project from this template

Example: you want a new project called **`Library App`**.

### Step 1: Copy the folder

1. In File Explorer, copy the **`JavaFX Project`** folder and paste it where you want.
2. Rename the copy to **`Library App`**.
3. Delete the folders **`build`**, **`bin`** and **`.gradle`** inside the copy, if they exist. They are old build output. The `.gradle` folder is hidden, so in File Explorer use **View → Hidden items** to see it.

### Step 2: Change the project name

Open `settings.gradle` and change:
```groovy
rootProject.name = 'javafx-project'
```
to:
```groovy
rootProject.name = 'library-app'
```
(Use lowercase letters and dashes, no spaces.)

### Step 3 (optional but cleaner): Rename the package

The template uses the package **`app`**. You can keep it, or rename it to something like `library`.

If you rename it, change it in **4 places**:

| Where | Before | After |
|---|---|---|
| Folder `src/main/java/app` | `app` | `library` |
| Folder `src/main/resources/app` | `app` | `library` |
| First line of `MainApp.java` | `package app;` | `package library;` |
| `module-info.java` | `module app {` … `exports app;` … `opens app to javafx.fxml;` | `module library {` … `exports library;` … `opens library to javafx.fxml;` |

Then in `build.gradle`:
```groovy
application {
    mainModule = 'library'            // = the name after "module" in module-info.java
    mainClass  = 'library.MainApp'    // = package.ClassName
}
```

> **Easier way:** in VS Code, right-click the `app` folder under `src/main/java` → **Rename** (or press `F2`). The Java extension updates the `package` lines for you. You still need to fix `module-info.java`, `build.gradle` and the `resources` folder by hand.

### Step 4 (optional): Rename the main class

If you rename `MainApp.java` to, for example, `LibraryApp.java`:
- In VS Code, right-click the file → **Rename** (`F2`) so the class name inside also changes.
- Update `mainClass` in `build.gradle` → `'library.LibraryApp'`.

### Step 5: Open and run

Open the new folder in VS Code (**File → Open Folder**) and run it as in [Part 3](#part-3--open-and-run-this-project-in-vs-code).

### Checklist: the 3 names that must match

```
module-info.java    module  library  { ... }
                            ^^^^^^^
build.gradle        mainModule = 'library'
                    mainClass  = 'library.MainApp'
                                  ^^^^^^^ ^^^^^^^
MainApp.java        package library;          public class MainApp
```

---

## Part 5 – Write your own code

### Add a new class

1. In the Explorer, right-click the package folder (`src/main/java/app`) → **New Java File → Class...** (or just create `Student.java`).
2. Make sure the first line is `package app;` (your package name).
3. Use it from `MainApp` normally: `Student s = new Student(...);`

**Good habit:** keep your normal Java classes (models, logic, like `Student` or `Library`) **free of JavaFX code**. Only `MainApp` (and other "view" classes) should create windows and buttons. That's what the `Project Java` folder does.

### Add a sub-package

If you create a new package, for example `app.model` (folder `src/main/java/app/model`), add it to `module-info.java` **only if JavaFX needs to access it** (for example, FXML controllers in that package):
```java
opens app.model to javafx.fxml;
```
Plain classes that only your own code uses don't need anything.

### Change the style (CSS)

Edit `src/main/resources/app/style.css`. JavaFX CSS looks like web CSS, but the properties start with `-fx-`:
```css
.button { -fx-background-color: green; -fx-text-fill: white; }
```
To style a single control, give it a class in Java, then target it in CSS:
```java
myLabel.getStyleClass().add("error");     // in Java
```
```css
.error { -fx-text-fill: red; }            /* in style.css */
```

### Add more JavaFX modules

In `build.gradle`, add the module to the list:
```groovy
modules = ['javafx.controls', 'javafx.fxml', 'javafx.media']
```
and in `module-info.java`:
```java
requires javafx.media;
```

| Module | Used for |
|---|---|
| `javafx.controls` | buttons, labels, text fields, tables, charts… (always needed) |
| `javafx.fxml` | loading `.fxml` files |
| `javafx.media` | playing audio / video |
| `javafx.web` | `WebView` (a mini web browser) |
| `javafx.swing` | mixing Swing and JavaFX |

### Add a library from the internet

1. Find the library on https://central.sonatype.com and copy its **Gradle** line (format `group:name:version`).
2. In `build.gradle`, add a `dependencies` block:
   ```groovy
   dependencies {
       implementation 'group:name:version'
   }
   ```
3. Because this is a **modular** project (it has `module-info.java`), also add `requires <module name>;` to `module-info.java`. The library's page or README tells you its module name, and VS Code usually suggests it if you hover over the red error.
   - Built-in Java modules work the same way, for example `requires java.sql;` for databases (JDBC).
4. Click the **🔄 Reload** button in the Gradle panel. If VS Code still doesn't see the library: `Ctrl+Shift+P` → **Java: Clean Java Language Server Workspace**.

---

## Part 6 – Optional: FXML and Scene Builder

FXML lets you **draw the UI** with the mouse instead of writing it in Java. The template already includes `javafx.fxml`.

1. Install **Scene Builder** from https://gluonhq.com/products/scene-builder/
2. Create `src/main/resources/app/main-view.fxml` (Scene Builder: **File → New**, then **Save As** there).
3. Create a controller class `src/main/java/app/MainController.java`:
   ```java
   package app;

   import javafx.fxml.FXML;
   import javafx.scene.control.Label;

   public class MainController {
       @FXML private Label message;          // fx:id="message" in the FXML

       @FXML
       private void onHelloClick() {         // onAction="#onHelloClick" in the FXML
           message.setText("Hello from FXML!");
       }
   }
   ```
4. In Scene Builder, set the controller (left panel **Controller → Controller class**: `app.MainController`), give controls an `fx:id`, and set `On Action` to `onHelloClick`.
5. Load the FXML in `MainApp.start(...)`:
   ```java
   // add: import javafx.fxml.FXMLLoader;  import javafx.scene.Parent;
   // and add "throws Exception" to start(...)
   Parent root = FXMLLoader.load(getClass().getResource("main-view.fxml"));
   Scene scene = new Scene(root, 480, 300);
   ```

The line `opens app to javafx.fxml;` in `module-info.java` is what allows FXML to fill the `@FXML` fields of your controller.

---

## Part 7 – Plain Java (no JavaFX) in any folder

For simple exercises you don't need Gradle at all:

1. Create any folder, for example `Exercises`, and open it in VS Code.
2. Create `Hello.java`:
   ```java
   public class Hello {
       public static void main(String[] args) {
           System.out.println("Hello!");
       }
   }
   ```
3. Click **Run** above `main`, or in the terminal:
   ```
   java Hello.java
   ```

Swing (`javax.swing`) is included in the JDK, so Swing programs also work this way. Only **JavaFX** needs the Gradle project.

---

## Part 8 – Troubleshooting

| Problem | Solution |
|---|---|
| `java` is not recognized in the terminal | Close **all** VS Code windows and reopen VS Code (it reads PATH only at start). Still failing? Reinstall the JDK with the "Add to PATH" option. |
| *"Error: JavaFX runtime components are missing"* | You ran the file directly (Code Runner ▷ or `java MainApp.java`). Run with the **Gradle panel → application → run** or `.\gradlew run`. |
| Red errors everywhere, *"javafx cannot be resolved"* | Wait until the import finishes (status bar). If it still fails: `Ctrl+Shift+P` → **Java: Clean Java Language Server Workspace** → **Restart and delete**. |
| *"Module app not found"* / *"Could not find or load main class"* | The names don't match. Check the [3-names checklist](#checklist-the-3-names-that-must-match): `module-info.java`, `mainModule`, `mainClass`, `package`. |
| `NullPointerException` at `getResource("style.css")` | The CSS (or FXML) file is not in `src/main/resources/<same package folder>/`. The folder name must match the package of the class. |
| FXML error *"cannot access class ... module app does not open app"* | Add `opens app to javafx.fxml;` (with your package name) in `module-info.java`. |
| First run is very slow / fails offline | The first run needs internet to download JavaFX and Gradle. After that, it works offline. |
| Gradle panel is empty | Make sure you opened the **project folder itself** (the one containing `build.gradle`), not its parent folder. |
| Changing the JDK version | Update the 3 paths in the global settings ([Part 2.3](#23-global-vs-code-settings)) and `options.release` in `build.gradle`. |
