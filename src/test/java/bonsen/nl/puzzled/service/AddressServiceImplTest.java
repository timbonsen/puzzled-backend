package bonsen.nl.puzzled.service;

import bonsen.nl.puzzled.model.address.Address;
import bonsen.nl.puzzled.repository.AddressRepository;
import bonsen.nl.puzzled.service.address.AddressService;
import bonsen.nl.puzzled.service.address.AddressServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTest {

    @InjectMocks
    private final AddressService addressService = new AddressServiceImpl();

    @Mock
    private AddressRepository addressRepository;

    private Address address;

    @BeforeEach
    void setUp() {
        address = new Address("Pandastraat", "19", "1234AB", "Pandastad", "Pandaland");
    }

    @Test
    void test_createAddress() {
        Mockito.when(addressRepository.save(address)).thenReturn(address);

        String addressId = addressService.createAddress(address);

        Assertions.assertNotNull(addressId);
        Assertions.assertSame(addressId, address.getId());
    }

    @Test
    void test_updateAddress() {
        Mockito.when(addressRepository.findById(address.getId())).thenReturn(java.util.Optional.ofNullable(address));
        Mockito.when(addressRepository.save(address)).thenReturn(address);

        boolean hasWorked = addressService.updateAddress(address);

        Assertions.assertTrue(hasWorked);
    }

    @Test
    void test_deleteAddress() {
        Mockito.when(addressRepository.existsById(address.getId())).thenReturn(false);

        boolean hasWorked = addressService.deleteAddress(address.getId());

        Assertions.assertTrue(hasWorked);
    }
}
