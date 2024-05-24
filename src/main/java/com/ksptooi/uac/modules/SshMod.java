<<<<<<< HEAD:src/main/java/com/ksptooi/psm/shell/SshServerProvider.java
package com.ksptooi.psm.shell;
=======
package com.ksptooi.uac.modules;
>>>>>>> parent of ef43788 (﻿更新: SSHD):src/main/java/com/ksptooi/uac/modules/SshMod.java

import com.google.inject.*;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;

import java.io.IOException;

public class SshMod extends AbstractModule {


    @Override
    protected void configure() {
        super.configure();
    }



    @Provides
    @Singleton
    public SshServer sshServer(){

        try {

            SshServer sshd = SshServer.setUpDefaultServer();
            sshd.setPort(1100);
            sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider());

            sshd.setPasswordAuthenticator(new PasswordAuthenticator() {
                @Override
                public boolean authenticate(String username, String password, ServerSession session) {
                    return "user".equals(username) && "password".equals(password);  // 简单的用户名密码验证
                }
            });


            sshd.start();
            return sshd;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
