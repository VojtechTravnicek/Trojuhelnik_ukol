import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.*;

public class MenuForm extends JFrame {
    private JButton Lze_sestrojit;
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField cTextField;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JButton dosazeni;
    private JPanel panel;

    private String cislo;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuHelp;
    private JMenuItem miOpenFile;
    private JMenuItem miSaveFile;

    private JMenuItem miKopiruj;

    private JMenuItem miSestrojit;

    private JFileChooser fileChooser = new JFileChooser(".");

    public MenuForm() {

        menuBar = new JMenuBar();
        menuFile = new JMenu("Soubor");
        menuFile.setMnemonic(KeyEvent.VK_F);


        miOpenFile = new JMenuItem("Načti", KeyEvent.VK_N);
        miOpenFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showOpenDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        BufferedReader reader = new BufferedReader(new FileReader(file));
                        String line = reader.readLine();
                        String[] values = line.split(",");
                        textFieldA.setText(values[0]);
                        textFieldB.setText(values[1]);
                        textFieldC.setText(values[2]);
                        reader.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        menuFile.add(miOpenFile);


        miSaveFile = new JMenuItem("Ulož", KeyEvent.VK_S);
        miSaveFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileChooser.showSaveDialog(panel);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        FileWriter writer = new FileWriter(file);
                        writer.write(textFieldA.getText() + "," + textFieldB.getText() + "," + textFieldC.getText());
                        writer.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        menuFile.add(miSaveFile);

        menuBar.add(menuFile);

        menuHelp = new JMenu("Akce");
        menuHelp.setMnemonic(KeyEvent.VK_H);
        menuBar.add(menuHelp);
        // vytvoření položky "Dosazeni"
        JMenuItem miDosazeni = new JMenuItem("Dosazeni", KeyEvent.VK_D);
        miDosazeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldB.setText(textFieldA.getText());
                textFieldC.setText(textFieldA.getText());
            }
        });
        menuHelp.add(miDosazeni);

        JMenuItem miLzeSestrojit = new JMenuItem("Lze sestrojit", KeyEvent.VK_L);
        miLzeSestrojit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strA = textFieldA.getText();
                String strB = textFieldB.getText();
                String strC = textFieldC.getText();

                if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Zadejte prosím délky všech stran", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double a = Double.parseDouble(strA);
                double b = Double.parseDouble(strB);
                double c = Double.parseDouble(strC);


                if (a + b > c && a + c > b && b + c > a) {
                    JOptionPane.showMessageDialog(panel, "Lze sestrojit trojúhelník", "Výsledek", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Nelze sestrojit trojúhelník", "Výsledek", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        menuHelp.add(miLzeSestrojit);


        setJMenuBar(menuBar);


        dosazeni.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldB.setText(textFieldA.getText());
                textFieldC.setText(textFieldA.getText());

            }
        });
        Lze_sestrojit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String strA = textFieldA.getText();
                String strB = textFieldB.getText();
                String strC = textFieldC.getText();

                if (strA.isEmpty() || strB.isEmpty() || strC.isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Zadejte prosím délky všech stran", "Chyba", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                double a = Double.parseDouble(strA);
                double b = Double.parseDouble(strB);
                double c = Double.parseDouble(strC);


                if (a + b > c && a + c > b && b + c > a) {
                    JOptionPane.showMessageDialog(panel, "Lze sestrojit trojúhelník", "Výsledek", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(panel, "Nelze sestrojit trojúhelník", "Výsledek", JOptionPane.INFORMATION_MESSAGE);
                }


            }
        });


    }

    public static void main(String[] args) {

        MenuForm frame = new MenuForm();
        frame.setContentPane(frame.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }}