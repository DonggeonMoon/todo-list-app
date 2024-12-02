package com.dgmoonlabs.todolistapp.member.stub;

import com.dgmoonlabs.todolistapp.member.domain.MemberSecurity;

public abstract class UnitTestStub {
    public static final String USERNAME = "testId";
    public static final String PASSWORD = "password";
    public static final String MEMBER_NAME = "James";
    public static final String EMAIL = "james02@gmail.com";
    public static final MemberSecurity MEMBER_SECURITY = MemberSecurity.create();
    public static final long ID = 1L;
}
