package com.emregvn.demov1.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProjectsByEmployeeIdResponse {
	private int id;
	private String name;
}
