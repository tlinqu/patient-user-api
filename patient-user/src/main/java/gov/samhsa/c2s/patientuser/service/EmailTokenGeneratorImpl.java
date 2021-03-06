package gov.samhsa.c2s.patientuser.service;

import gov.samhsa.c2s.patientuser.domain.UserCreationRepository;
import gov.samhsa.c2s.common.util.UniqueValueGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailTokenGeneratorImpl implements EmailTokenGenerator {

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private UserCreationRepository userCreationRepository;

    @Override
    @Transactional(readOnly = true)
    public String generateEmailToken() {
        short trialLimit = 3;
        return UniqueValueGenerator.generateUniqueValue(tokenGenerator::generateToken, this::isUnique, trialLimit);
    }

    private boolean isUnique(String emailToken) {
        return !userCreationRepository.findOneByEmailToken(emailToken).isPresent();
    }
}