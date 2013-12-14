package com.prodyna.vfs.model;



public abstract class FolderImpl extends NodeImpl implements Folder {
	@Override
	public NodeType getType() {
		return NodeType.FOLDER;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FolderImpl [getType()=" + getSystemType() + ", getName()="
				+ getName() + "]";
	}
}
