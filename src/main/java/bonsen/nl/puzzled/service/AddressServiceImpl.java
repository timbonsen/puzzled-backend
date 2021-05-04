package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.exceptions.RecordNotFoundException;
import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public String createAddress(Address address) {
        Address newAddress = addressRepository.save(address);
        return newAddress.getId();
    }

    @Override
    public void updateAddress(Address newAddress) {
        String id = newAddress.getId();
        if (!addressRepository.existsById(id)) throw new RecordNotFoundException();
        Address address = addressRepository.findById(id).get();
        address.setStreetName(newAddress.getStreetName());
        address.setHouseNumber(newAddress.getHouseNumber());
        address.setPostalCode(newAddress.getPostalCode());
        address.setCity(newAddress.getCity());
        address.setCountry(newAddress.getCountry());
        addressRepository.save(address);
    }

    @Override
    public void deleteAddress(String id) {
        addressRepository.deleteById(id);
    }

}
