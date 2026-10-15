package me.acablade.sboxgaming.provider;

import me.acablade.sboxgaming.link.Link;
import me.acablade.sboxgaming.platform.AccountLinkingActor;

import java.net.URI;
import java.util.Optional;

public sealed interface AccountLinking<T extends AccountLinkingActor> permits AccountLinkingDummy, AccountLinkingGoogle {

    String id();

    URI startLink(T actor);
    Link<T> completeLink(String state, String code);
    Optional<Link<T>> find(T actor);
    void unlinkActor(T actor);

    // might get deleted. seems exploitable to me.
    void unlinkEmail(String email);

}
