package com.worldofthings.dao;

/*
 * #%L
 * DeviceHive Dao RDBMS Implementation
 * %%
 * Copyright (C) 2016 DataArt
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.worldofthings.vo.VirtualObjectVO;

import java.util.Optional;

@Repository
@Qualifier("cassandra")
public class PersistanceDaoCassandraImpl  implements PersistanceObjectDao {

	/*Persistance Repository (CassandaraRepository or HibernateRepository operations abstraction
	 Object Curd Operation will  work with Virual Objects to hide the persistance abstraction
	 * */
	
	@Override
	public VirtualObjectVO getByName(String name) {
		return new VirtualObjectVO("Test","test") ;
	}

	@Override
	public int delete(String name) {
		return 0;
	}

	@Override
	public void persist(VirtualObjectVO configuration) {
	}

	@Override
	public VirtualObjectVO merge(VirtualObjectVO existing) {
		return null;
	}

}
