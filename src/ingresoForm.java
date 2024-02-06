import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ingresoForm {
    JPanel form1;
    private JButton button1;
    private JTextField mensajeTxt;

    public ingresoForm() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conectarDB miconexion=new conectarDB();
                miconexion.conexionlocal("jdbc:mysql://localhost:3306/estudiantes","root","");
                mensajeTxt.setText(miconexion.getMensaje());
            }
        });
    }
}
