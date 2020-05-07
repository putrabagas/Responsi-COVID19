import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Read extends JFrame {
    String[][] datas = new String[500][6];
    String[] kolom = {"ID","Tanggal", "Negara", "Positif", "Sembuh","Meninggal"};
    JLabel lTitle;
    JTable tTable;
    JButton bBack;
    JScrollPane scrollPane;
    ResultSet resultSet;
    Statement statement;

    public Read(){
        setTitle("DATA COVID-19");

        lTitle = new JLabel("Data COVID-19");
        lTitle.setFont(new Font("tahoma", Font.BOLD, 18));
        bBack = new JButton("Kembali");
        bBack.setFont(new Font("Regular",Font.PLAIN, 14));
        tTable = new JTable(datas, kolom);
        tTable.setBackground(new Color(220, 252, 255));
        scrollPane = new JScrollPane(tTable);

        setLayout(null);
        add(lTitle);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(185, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bBack.setBounds(230, 490, 90, 30);

        setSize(570, 620);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });

        Koneksi connec = new Koneksi();
        try {
            statement = connec.getConnection().createStatement();
            String sql = "SELECT * FROM covid";
            //String sql = "SELECT negara,sum(positif),sum(sembuh),sum(meninggal) FROM covid GROUP BY negara ASC";
            resultSet = statement.executeQuery(sql);

            int row = 0;
            while (resultSet.next()){
                datas[row][0] = resultSet.getString("id");
                datas[row][1] = resultSet.getString("tanggal");
                datas[row][2] = resultSet.getString("negara");
                datas[row][3] = resultSet.getString("positif");
                datas[row][4] = resultSet.getString("sembuh");
                datas[row][5] = resultSet.getString("meninggal");
                
                
                row++;
            }
            statement.close();
            
            

        } catch (SQLException sqlError) {
            JOptionPane.showMessageDialog(rootPane, "Data Gagal Ditampilkan" + sqlError);
        } catch (ClassNotFoundException classError) {
            JOptionPane.showMessageDialog(rootPane, "Driver tidak ditemukan !!");
        }
    }
}
