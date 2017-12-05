package labs;

import java.awt.Color;
import java.awt.Label;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.IOException;

import javax.swing.JLabel;

public class DraggableLabel extends JLabel implements DragGestureListener, DragSourceListener, DropTargetListener 
{
    private DragSource dragSource;
    private ColorCallBack ccb;
    public DraggableLabel(String text) {
		setText(text);
		
		dragSource = new DragSource();
		
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
		
		
    }
    
    public DraggableLabel(String text,boolean allowDrop) {
    	this(text);
    	if(allowDrop) {
    		new DropTarget(this,this);
    	}
    }
    
    public DraggableLabel(String text,boolean allowDrop,ColorCallBack ccb) {
    	this(text,allowDrop);
    	this.ccb = ccb;
    	
    }

    public void dragGestureRecognized(DragGestureEvent evt) {
    	Transferable transferable;
    	if(getText().equals("")) {
    		transferable = new StringSelection(super.getBackground().getRGB()+"");
    	} else {
    		transferable = new StringSelection(super.getText());
    	}
		dragSource.startDrag(evt, DragSource.DefaultCopyDrop, transferable, this);

    }

    public void dragEnter(DragSourceDragEvent evt) {
    }

    public void dragOver(DragSourceDragEvent evt) {
    }

    public void dragExit(DragSourceEvent evt) {
    }

    public void dropActionChanged(DragSourceDragEvent evt) {
    	
    }

    public void dragDropEnd(DragSourceDropEvent evt) {
    	
    }

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		
	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		
	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		
	}

	@Override
	public void drop(DropTargetDropEvent arg0) {
		try {
		    Transferable transferable = arg0.getTransferable();
		    if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {
		    	String dragContents = (String) transferable.getTransferData(DataFlavor.stringFlavor);
		    	try {
		    		Color c = Color.decode(dragContents);
		    		super.setBackground(c);
		    		if(ccb!=null) {
		    			ccb.setColor(c);
		    		}
		    	} catch(NumberFormatException e) {
		    		arg0.rejectDrop();
		    	}
	    	} else {
	    		arg0.rejectDrop();
	    	}
		} catch (IOException e) {
			arg0.rejectDrop();
		} catch (UnsupportedFlavorException e) {
			arg0.rejectDrop();
		}
    }


	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		
	}
	
	

}

