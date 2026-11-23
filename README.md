# Latihan/Eksplorasi GUI pada Java (AWT)

Program sederhana "Form Sapaan Mahasiswa" untuk mengeksplorasi komponen GUI Java menggunakan **AWT** (`java.awt` dan `java.awt.event`).

- **NIM:** f1D02510032
- **Nama:** Ade Zulfikar Rajasa

## Cara Menjalankan

```bash
javac LatihanGUI.java
java LatihanGUI
```

## 5 Komponen Utama GUI yang Digunakan

### 1. Top-Level Container: `Frame`
Jendela utama aplikasi. Semua komponen lain diletakkan di dalamnya. Dipakai untuk mengatur judul, ukuran, posisi, dan layout utama.

### 2. Intermediate Container: `Panel`
Wadah perantara untuk mengelompokkan komponen. Pada program ini ada tiga panel: `panelForm` (input), `panelTombol` (tombol), dan `panelBawah` (tombol + hasil).

### 3. Atomic Component: `Label`, `TextField`, `Choice`, `Checkbox`, `Button`, `TextArea`
Komponen dasar yang berinteraksi langsung dengan pengguna dan tidak bisa menampung komponen lain.

### 4. Layout Classes: `BorderLayout`, `GridLayout`, `FlowLayout`
- `BorderLayout`: menata `Frame` menjadi bagian atas (judul), tengah (form), dan bawah (hasil).
- `GridLayout`: menata form dalam grid 3 baris x 2 kolom.
- `FlowLayout`: menata tombol secara berurutan dan rata tengah.

### 5. Event Listener & Event Adapter (`java.awt.event`)
- `ActionListener` (interface): meng-override `actionPerformed()` untuk tombol **Sapa** dan **Reset**, serta Enter pada kolom nama.
- `MouseAdapter` (adapter class): hanya meng-override `mouseEntered()` dan `mouseExited()` untuk efek hover pada tombol, tanpa harus mengimplementasikan semua method `MouseListener`.
- `WindowAdapter` (adapter class): meng-override `windowClosing()` agar jendela bisa ditutup.
