package uw.cs.watform.forml.extensions.EmbeddedLinkEditor;

import org.eclipse.jface.text.Position;

public class LinkedTextHyperlink extends Position {

  private final Object _target;

  private LinkedTextHyperlink(int offset, int length, Object target){
    super(offset, length);
    _target = target;
  }

  public static LinkedTextHyperlink create(int offset, int length, Object target){
    return new LinkedTextHyperlink(offset, length, target);
  }

  public Object getTarget(){
    return _target;
  }

}