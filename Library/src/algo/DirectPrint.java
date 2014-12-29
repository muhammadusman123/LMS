package algo;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.print.PrintService;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.PageRanges;
/**
 * 
 * @author Muhammad Usman
 *
 */
public class DirectPrint implements Printable {
	private PrintService[] printService;
	private String text;
	/**
	 * 
	 */
	public DirectPrint() {
		this.printService = PrinterJob.lookupPrintServices();
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	}
	/**
	 * 
	 * @param s
	 */
	public void printing(String s) {
		DirectPrint lt = new DirectPrint();
		lt.printString(s);
	}
	/**
	 * 
	 * @param input
	 */
	public void printString(String input) {
		this.text = input;
		PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
		aset.add(new PageRanges(1, 1));
		aset.add(new Copies(1));
		PrinterJob printJob = PrinterJob.getPrinterJob();
		printJob.setPrintable(this);
		try {
			printJob.setPrintService(printService[2]);
			// index of installed printers on you system
			// not sure if default-printer is always '0'
			printJob.print(aset);
		} catch (PrinterException err) {
			System.err.println(err);
		}
	}
	/**
	 * 
	 */
	// @Override
	@Override
	public int print(Graphics g, PageFormat pf, int pageIndex)
			throws PrinterException {
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(pf.getImageableX(), pf.getImageableY());
		g.drawString(String.valueOf(this.text), 14, 14);
		return PAGE_EXISTS;
	}
}