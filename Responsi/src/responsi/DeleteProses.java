import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DeleteProses extends JFrame {
    Statement statement;
    ResultSet resultSet;
    JButton bDelete, bBack;
    JLabel lTitle, lId, lNote;
    JTextField fId;

    public void ProcessDelete() {
        this.lTitle = new JLabel("Hapus Data");
        this.lId = new JLabel("ID ");
        lNote=new JLabel ("*Masukkan ID yang akan dihapus");
        lNote.setFont(new Font("Regular", Font.PLAIN, 11));
        this.bDelete = new JButton("Hapus");
        this.bBack = new JButton("Kembali");
        this.fId = new JTextField();
        
        this.setTitle("Hapus Data");
        this.setSize(300, 200);
        this.lTitle.setHorizontalAlignment(0);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.setLayout((LayoutManager)null);

        this.add(this.lTitle);
        this.add(this.lId);
        this.add(this.fId);
        this.add(this.lNote);
        this.add(this.bDelete);
        this.add(this.bBack);

        this.lTitle.setBounds(50, 10, 150, 25);
        this.lId.setBounds(50, 55, 100, 25);
        this.fId.setBounds(100, 55, 100, 25);
        this.lNote.setBounds(50, 30, 200, 25);
        this.bBack.setBounds(140, 90, 100, 25);
        this.bDelete.setBounds(30, 90, 100, 25);
        this.bBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DeleteProses.this.setVisible(false);
                new Menu();
            }
        });
        this.bDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DeleteProses.this.btnDelactionListener();
                new Read();
            }
        });
    }

    private void btnDelactionListener() {
        Koneksi koneksi = new Koneksi();
        try {
            this.statement = koneksi.getConnection().createStatement();
            this.statement.executeUpdate("DELETE FROM covid WHERE id='" + this.fId.getText() + "'");
            JOptionPane.showMessageDialog((Component)null, "Data berhasil di Hapus!", "Hasil", 1);
            this.statement.close();
        } catch (SQLException var3) {
            JOptionPane.showMessageDialog((Component)null, "Data Gagal di Hapus!", "Hasil", 0);
        } catch (ClassNotFoundException var4) {
            JOptionPane.showMessageDialog((Component)null, "Driver Tidak Ditemukan!", "Hasil", 0);
        }

    }
}