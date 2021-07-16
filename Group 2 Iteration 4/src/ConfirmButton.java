/*
 * @author Thu Dinh
 */
import javax.swing.*;
public class ConfirmButton extends JButton 
{
	public ConfirmButton()
	{
		super("Confirm");
		this.addActionListener(evt -> UpdateGame.confirm());
	}
}
