package com.woowatm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class accountHolder {
	private String pin;
	private String accType;
	private String bankName;
	private String branchName;
	private String name;
	private String accNo;
}
