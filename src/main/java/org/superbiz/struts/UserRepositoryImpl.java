/*

    Licensed to the Apache Software Foundation (ASF) under one or more
    contributor license agreements.  See the NOTICE file distributed with
    this work for additional information regarding copyright ownership.
    The ASF licenses this file to You under the Apache License, Version 2.0
    (the "License"); you may not use this file except in compliance with
    the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
*/
package org.superbiz.struts;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private CrudRepository<User, Long> mJPA;

    public UserRepositoryImpl(EntityManager manager) {
        mJPA = new SimpleJpaRepository<User, Long>(User.class, manager);
    }

    @Transactional
    public void save(User user) {
        mJPA.save(user);
    }

    public User findOne(long id) {
        return mJPA.findOne(id);
    }

    public List<User> findAll() {
        ArrayList<User> list = new ArrayList<>();
        mJPA.findAll().forEach(list::add);
        return list;
    }
}
