import java.awt.*;
import java.awt.event.*;

public class LatihanGUI {
    public static void main(String[] args) {
        // 1. TOP-LEVEL CONTAINER: Frame
        Frame frame = new Frame("Latihan GUI Java - Form Sapaan");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10)); // LAYOUT 1: BorderLayout

        // 2. ATOMIC COMPONENTS
        Label judul = new Label("Form Sapaan Mahasiswa", Label.CENTER);
        judul.setFont(new Font("Arial", Font.BOLD, 18));

        Label lblNama = new Label("Nama:");
        TextField txtNama = new TextField();

        Label lblJurusan = new Label("Jurusan:");
        Choice cmbJurusan = new Choice();
        cmbJurusan.add("Teknik Informatika");
        cmbJurusan.add("Sistem Informasi");
        cmbJurusan.add("Teknik Elektro");
        cmbJurusan.add("Lainnya");

        Checkbox chkFormal = new Checkbox("Gunakan sapaan formal");

        Button btnSapa = new Button("Sapa");
        Button btnReset = new Button("Reset");

        TextArea areaHasil = new TextArea("", 4, 20, TextArea.SCROLLBARS_VERTICAL_ONLY);
        areaHasil.setEditable(false);

        // 3. INTERMEDIATE CONTAINER: Panel
        // Panel form memakai LAYOUT 2: GridLayout
        Panel panelForm = new Panel(new GridLayout(3, 2, 8, 8));
        panelForm.add(lblNama);
        panelForm.add(txtNama);
        panelForm.add(lblJurusan);
        panelForm.add(cmbJurusan);
        panelForm.add(new Label(""));
        panelForm.add(chkFormal);

        // Panel tombol memakai LAYOUT 3: FlowLayout
        Panel panelTombol = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        panelTombol.add(btnSapa);
        panelTombol.add(btnReset);

        // Panel bawah (tombol + hasil) memakai BorderLayout
        Panel panelBawah = new Panel(new BorderLayout());
        panelBawah.add(panelTombol, BorderLayout.NORTH);
        panelBawah.add(areaHasil, BorderLayout.CENTER);

        // 4. EVENT LISTENER (interface): ActionListener
        ActionListener aksiSapa = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = txtNama.getText().trim();
                if (nama.isEmpty()) {
                    areaHasil.setText("Peringatan: Nama tidak boleh kosong!");
                    return;
                }
                String jurusan = cmbJurusan.getSelectedItem();
                String sapaan = chkFormal.getState()
                        ? "Selamat datang, Saudara/i " + nama
                        : "Halo, " + nama + "!";
                areaHasil.setText(sapaan + "\nJurusan: " + jurusan);
            }
        };
        btnSapa.addActionListener(aksiSapa);
        txtNama.addActionListener(aksiSapa); // tekan Enter = klik Sapa

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNama.setText("");
                cmbJurusan.select(0);
                chkFormal.setState(false);
                areaHasil.setText("");
            }
        });

        // 5. EVENT ADAPTER CLASS: MouseAdapter (override sebagian method saja)
        MouseAdapter efekHover = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                ((Button) e.getSource()).setBackground(Color.CYAN);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                ((Button) e.getSource()).setBackground(Color.LIGHT_GRAY);
            }
        };
        btnSapa.addMouseListener(efekHover);
        btnReset.addMouseListener(efekHover);

        // EVENT ADAPTER CLASS: WindowAdapter (agar tombol close di Frame berfungsi)
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
                System.exit(0);
            }
        });

        // Susun semua ke frame
        frame.add(judul, BorderLayout.NORTH);
        frame.add(panelForm, BorderLayout.CENTER);
        frame.add(panelBawah, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}