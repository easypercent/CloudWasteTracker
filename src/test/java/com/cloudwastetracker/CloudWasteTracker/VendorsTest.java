package com.cloudwastetracker.CloudWasteTracker;

import com.cloudwastetracker.CloudWasteTracker.vendor.Vendors;
import com.cloudwastetracker.CloudWasteTracker.vendor.VendorsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@DataJpaTest
public class VendorsTest {

    @Autowired
    VendorsRepository subject;

    @Test
    public void testRepositorySave() throws Exception {
        Vendors v = new Vendors();
        String key = "testkey";
        v.setVendorKey(key);
        v.setVendorDescription("testdescription");
        v.setVendorLabel("testlabel");
        subject.save(v);
        assertTrue(subject.findById(key).isPresent());
    }

    @Test
    public void testRepositoryGet() throws Exception {
        Vendors v = new Vendors();
        String key = "testkey";
        v.setVendorKey(key);
        v.setVendorDescription("testdescription");
        v.setVendorLabel("testlabel");
        subject.save(v);

        assertTrue(subject.findById(key).isPresent());
        Vendors v2 = subject.findById(key).get();
        assertEquals(v.getVendorKey(), v2.getVendorKey());
        assertEquals(v.getVendorDescription(), v2.getVendorDescription());
		assertEquals(v.getVendorLabel(), v2.getVendorLabel());
    }

    @Test
    public void testRepositoryGetAll() throws Exception {
        Vendors v = new Vendors();
        String key = "testkey";
        v.setVendorKey(key);
        v.setVendorDescription("testdescription");
		v.setVendorLabel("testlabel");
        subject.save(v);

        assertTrue(subject.findAll().iterator().hasNext());
    }
}
