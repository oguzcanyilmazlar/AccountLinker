package me.acablade.sboxgaming;

import me.acablade.sboxgaming.impl.DummyActor;
import me.acablade.sboxgaming.impl.DummyActorCodec;
import me.acablade.sboxgaming.link.InMemoryLinkStore;
import me.acablade.sboxgaming.link.LinkStore;
import me.acablade.sboxgaming.platform.AccountLinkingPlatform;
import me.acablade.sboxgaming.provider.AccountLinkingDummy;

public class Main {

    public static void main(String[] args){
        LinkStore<DummyActor> store = new InMemoryLinkStore<>();
        AccountLinkingPlatform<DummyActor> platform = AccountLinkingPlatform
                .builder(new DummyActorCodec())
                .providers(new AccountLinkingDummy<>(store))
                .build();

        System.out.println(platform.provider("dummy").get().startLink(new DummyActor("test")));

    }

}
