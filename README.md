# ReSinauConsole
ReSinauConsole, is a semi-fork from the original [ReSinau](https://github.com/kalexs8/ReSinau.git), it intends to bring Android-version ReSinau available to computers.

It's primarily written in Pure Java, the SDK used to develop this project is OpenJDK 20. Although, you can download the binary from the [releases](https://github.com/) page, and install JRE 8 on your machine, then run the binary with:

```sh
java -jar resinau-VERSION.jar
```
or simply double-click it on windows.
That's all!

# Why use Java? Why not directly use native binaries?
I used Java, to lift OS compatibility issues.

# Why use the TUI (Text-User-Interface) / Console as the display?
As this is a prototype, I plan to make it a GUI (Graphical User Interface) for later.

# How can I set my own question router?
By default, the release JAR uses the one that ReSinau provides, but, if you decide to compile from source, you can change the `QUESTION_ROUTER` in the `RSConstants.java` file.

# Available Languages?
Currently, the interface uses the informal Indonesia setting.

# Other READMEs
The Indonesia version of this README is available at README-id.md