package com.dzjk.ams.core.common.enums;

/** @author climb.s
 * @date 2018/2/9 16:58 */
public enum Switch {
	valid("1"), invalid("0");

	private String code;

	Switch(String code) {
		this.code = code;
	}

	public static Switch parser(String code) {
		for (Switch $switch : Switch.values()) {
			try {
				if ($switch.code.equals(code)) {
					return $switch;
				}
			} catch (Exception e) {
			}
		}
		return null;
	}

	public boolean isValid() {
		return this.code.equals(Switch.valid.code);
	}
}
