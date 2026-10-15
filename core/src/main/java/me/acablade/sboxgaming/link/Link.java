package me.acablade.sboxgaming.link;

import me.acablade.sboxgaming.platform.AccountLinkingActor;

public record Link<T extends AccountLinkingActor>(T actor, String subject, String email) {}
