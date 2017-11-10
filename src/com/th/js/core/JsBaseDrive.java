package com.th.js.core;

import com.th.js.container.AnalysisResult;

/**
 * 驱动处理器 处理器的父类
 */
public abstract class JsBaseDrive {

	protected AnalysisResult result;
	protected Variables storage;
	protected CharPoint charPoint;
	protected JSScanner scanner;
	protected String item;

	public JsBaseDrive(Variables vals) {
		storage = vals;
	}

	public void clear() {
		storage.clear();
	}

	/**
	 * 解释JS
	 * @param item
	 * @return
	 */
	public AnalysisResult translation(JSScanner scanner) {
		if (result == null) {
			System.err.println("JsDrive.translation():AnalysisResult need instance,item:" + scanner.item());
			return null;
		}
		result.full(item = scanner.item());
		setCharPoint(scanner.getCharPoint());
		return result;
	}

	/**
	 * 实例化自身参数
	 * @param manager
	 */
	public void instance(RootManager manager) {
		result = new AnalysisResult();
		manager.fullDrive(this);
	}
	
	public void setCharPoint(CharPoint charPoint) {
		this.charPoint = charPoint;
		result.setPoint(charPoint);
	}
	
	public CharPoint getCharPoint() {
		return charPoint;
	}

}