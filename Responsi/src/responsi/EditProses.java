import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EditProses extends JFrame {
     JLabel lTitle, lNegara, lPositif, lSembuh, lMeninggal,lTanggal,lId,lNote;
    JTextField fNegara, fPositif, fSembuh, fMeninggal,fTanggal,fId;
    JButton bSave, bBack;
    Statement statement;

    public EditProses() {

        setTitle("EDIT DATA");
        lTitle = new JLabel("Edit Berdasarkan ID");
        lTitle.setFont(new Font("Regular", Font.PLAIN, 20));
        
        lId = new JLabel("ID ");
        lId.setFont(new Font("Regular", Font.PLAIN, 18));
        fId = new JTextField();
        fId.setFont(new Font("Regular", Font.PLAIN, 16));
        
        lNegara = new JLabel("Negara ");
        lNegara.setFont(new Font("Regular", Font.PLAIN, 18));
        fNegara = new JTextField();
        fNegara.setFont(new Font("Regular", Font.PLAIN, 16));
        
        lPositif = new JLabel("Positif ");
        lPositif.setFont(new Font("Regular", Font.PLAIN, 18));
        fPositif = new JTextField();
        fPositif.setFont(new Font("Regular", Font.PLAIN, 16));
        
        lSembuh = new JLabel("Sembuh ");
        lSembuh.setFont(new Font("Regular", Font.PLAIN, 18));
        fSembuh = new JTextField();
        fSembuh.setFont(new Font("Regular", Font.PLAIN, 16));
        
        lMeninggal = new JLabel("Meninggal ");
        lMeninggal.setFont(new Font("Regular", Font.PLAIN, 18));
        fMeninggal = new JTextField();
        fMeninggal.setFont(new Font("Regular", Font.PLAIN, 16));
        
        lTanggal = new JLabel("Tanggal ");
        lTanggal.setFont(new Font("Regular", Font.PLAIN, 18));
        fTanggal = new JTextField();
        fTanggal.setFont(new Font("Regular", Font.PLAIN, 16));
        lNote=new JLabel ("*Masukkan ID yang akan diedit");
        lNote.setFont(new Font("Regular", Font.PLAIN, 9));
        bSave = new JButton("Simpan");
        bSave.setFont(new Font("Regular",Font.PLAIN, 14));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        
        setLayout(null);
        add(lTitle);
         add(lId);
        add(fId);
        add(lNegara);
        add(fNegara);
        add(lPositif);
        add(fPositif);
        add(lSembuh);
        add(fSembuh);
        add(lMeninggal);
        add(fMeninggal);
        add(lTanggal);
        add(fTanggal);
        add(lNote);
        add(bSave);
        add(bBack);

        lTitle.setBounds(120, 20, 250, 30);
        lId.setBounds(30, 70, 120, 30);
        fId.setBounds(130, 73,270,25);
        lNegara.setBounds(30, 110, 120, 30);
        fNegara.setBounds(130, 110, 270, 30);
        lPositif.setBounds(30, 150, 120, 30);
        fPositif.setBounds(130, 153, 270, 25);
        lSembuh.setBounds(30, 190, 120, 30);
        fSembuh.setBounds(130, 193, 270, 25);
        lMeninggal.setBounds(30, 230, 120, 30);
        fMeninggal.setBounds(130, 233, 270, 25);
        lTanggal.setBounds(30, 270, 120, 30);
        fTanggal.setBounds(130, 273, 270, 25);
        lNote.setBounds(30, 50, 270, 25);
        bSave.setBounds(120, 350, 90, 30);
        bBack.setBounds(220, 350, 90,30);

        setSize(440, 450);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUpdateactionListener();
            }

            private void btnUpdateactionListener() {
                Koneksi connec = new Koneksi();
                try {
                    statement = connec.getConnection().createStatement();
                    statement.executeUpdate("UPDATE covid SET  tanggal='" +
                            fTanggal.getText() + "'," + "negara='" + fNegara.getText() + "'," + "positif='" + fPositif.getText() + "'," + "sembuh='" + fSembuh.getText() + "'," + "meninggal='" + fMeninggal.getText() + "'    WHERE id='" + fId.getText() + "'");
                    JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data gagal diupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        bBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                try {
                    new Edit();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EditProses.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(EditProses.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}