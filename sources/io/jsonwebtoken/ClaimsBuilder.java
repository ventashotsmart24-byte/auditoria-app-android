package io.jsonwebtoken;

import io.jsonwebtoken.lang.Builder;
import io.jsonwebtoken.lang.MapMutator;

public interface ClaimsBuilder extends MapMutator<String, Object, ClaimsBuilder>, ClaimsMutator<ClaimsBuilder>, Builder<Claims> {
}
