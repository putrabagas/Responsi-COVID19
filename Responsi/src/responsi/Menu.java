import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Menu extends JFrame {
    JLabel lTittle;
    JButton bCreate, bRead, bUpdate, bDelete, bExit;

    public void displayMenu(){
        setTitle("DATA COVID-19");
        lTittle = new JLabel("DATA COVID-19");
        lTittle.setFont(new Font("Regular", Font.BOLD, 18));
        bCreate = new JButton("Input ");
        bCreate.setFont(new Font("Regular",Font.PLAIN, 16));
        bRead = new JButton("Tampil ");
        bRead.setFont(new Font("Regular",Font.PLAIN, 16));
        bUpdate = new JButton("Edit ");
        bUpdate.setFont(new Font("Regular",Font.PLAIN, 16));
        bDelete = new JButton("Hapus ");
        bDelete.setFont(new Font("Regular",Font.PLAIN, 16));
        bExit = new JButton("Exit ");
        bExit.setFont(new Font("Regular",Font.PLAIN, 16));

        setLayout(null);
        add(lTittle);
        add(bCreate);
        add(bRead);
        add(bUpdate);
        add(bDelete);
        add(bExit);

        lTittle.setBounds(170,30,180,30);
        bCreate.setBounds(10, 80, 220, 30);
        bRead.setBounds(250, 80, 220, 30);
        bUpdate.setBounds(10, 120, 220, 30);
        bDelete.setBounds(250, 120, 220, 30);
        bExit.setBounds(185, 160, 100, 30);

        setSize(500, 280);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Create();
            }
        });
        bRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Read();
            }
        });
        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Delete();
                }catch (ClassNotFoundException classError){
                    classError.printStackTrace();
                }catch (SQLException sqlError){
                    sqlError.printStackTrace();
                }
            }
        });
        bUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Edit();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            }
        });

        bExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
