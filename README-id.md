# ReSinauConsole
ReSinauConsole adalah semi-fork dari [ReSinau](https://github.com/kalexs8/ReSinau.git) yang asli,
ini dibuat bertujuan untuk membawa ReSinau versi android ke komputer.

Projek ini dibuat murni dari Java, alat pengembangan yang dipakai dalam mengembangkan projek ini adalah OpenJDK 20. Tetapi, anda bisa mendownload JRE 8 saja dan mendownload program nya dari [rilisan](https://github.com/) yang sudah di sediakan, lalu jalankan programnya dengan:

```sh
java -jar resinau-VERSION.jar
```

atau mudahnya dengan mendouble-klik programnya.
Itu saja!

# Kenapa pakai Java? Tidak langsung exe?
Saya menggunakan Java, untuk mengurangi beban penulisan ulang kode di OS yang berbeda.

# Kenapa pakai interface TUI (Tampilan Teks) / Konsol sebagai tampilan?
Karena ini prototip, saya akan membuat GUI (Tampilan Bergrafis) nanti.

# Bagaimana saya menyetel router soal saya sendiri?
Defaultnya, rilisan JAR nya menggunakan yang sudah disediakan oleh ReSinau, namun, ketika anda
membangun ulang dari sumbernya, anda bisa merubah `QUESTION_ROUTER` di file `RSConstants.java`.

# Bahasa yang tersedia?
Saat ini, tampilannya menggunakan Bahasa Indonesia yang tidak formal.

# README lainnya
Versi English dari README ini sudah disediakan di README.md