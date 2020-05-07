import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete extends JFrame {
    Statement statement;
    ResultSet resultSet;
    String[][] datas = new String[500][6];
    String[] column = {"ID","Tanggal", "Negara", "Positif", "Sembuh","Meninggal"};
    JLabel lTitle;
    JButton bDelete, bBack;
    JTable tTable;
    JScrollPane scrollPane;

    public Delete() throws SQLException, ClassNotFoundException {
        lTitle = new JLabel ("DATA COVID-19");
        lTitle.setFont(new Font("Regular", Font.BOLD, 18));
        bDelete = new JButton ("Delete");
        bDelete.setFont(new Font("Regular", Font.PLAIN, 14));
        bBack = new JButton ("Kembali");
        bBack.setFont(new Font("Regular", Font.PLAIN, 14));
        tTable = new JTable(datas, column);
        scrollPane = new JScrollPane(tTable);
        
        setTitle("Hapus Data COVID-19");
        Koneksi connec = new Koneksi();
        statement = connec.getConnection().createStatement();
        String sql = "SELECT * FROM covid";
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
        setLayout(null);
        add(lTitle);
        add(bDelete);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(160, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bDelete.setBounds(170, 490, 90, 25);
        bBack.setBounds(280, 490, 90, 25);

        setSize(550,650);
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

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeleteProses hapus = new DeleteProses();
                hapus.ProcessDelete();
                setVisible(false);
            }
        });
    }
}
