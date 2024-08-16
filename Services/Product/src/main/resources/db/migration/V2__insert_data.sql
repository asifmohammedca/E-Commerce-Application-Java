
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Computer Keyboards', 'Keyboards');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Computer Monitors', 'Monitors');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Display Screens', 'Screens');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Computer Mice', 'Mice');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Computer Accessories', 'Accessories');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Portable personal computers', 'Laptops');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Audio listening devices', 'Headphones');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Devices for printing documents', 'Printers');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Devices for capturing video and images', 'Webcams');
INSERT INTO category (id, description, name) VALUES (nextval('category_seq'), 'Networking devices and equipment', 'Networking Equipment');




-- Insert products for the 'Keyboards' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 10, 'Mechanical keyboard with RGB lighting', 'Mechanical Keyboard 1', 99.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'), 15, 'Wireless compact keyboard', 'Wireless Compact Keyboard 1', 79.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'), 20, 'Backlit gaming keyboard with customizable keys', 'Gaming Keyboard 1', 129.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'), 25, 'Mechanical keyboard with wrist rest', 'Ergonomic Keyboard 1', 109.99, (SELECT id FROM category WHERE name = 'Keyboards')),
    (nextval('product_seq'), 18, 'Wireless keyboard and mouse combo', 'Wireless Combo 1', 69.99, (SELECT id FROM category WHERE name = 'Keyboards'));

-- Insert products for the 'Monitors' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 30, '27-inch IPS monitor with 4K resolution', '4K Monitor 1', 399.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'), 25, 'Ultra-wide gaming monitor with HDR support', 'Ultra-wide Gaming Monitor 1', 499.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'), 22, '24-inch LED monitor for office use', 'Office Monitor 1', 179.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'), 28, '32-inch curved monitor with AMD FreeSync', 'Curved Monitor 1', 329.99, (SELECT id FROM category WHERE name = 'Monitors')),
    (nextval('product_seq'), 35, 'Portable USB-C monitor for laptops', 'Portable Monitor 1', 249.99, (SELECT id FROM category WHERE name = 'Monitors'));

-- Insert products for the 'Screens' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 15, 'Curved OLED gaming screen with 240Hz refresh rate', 'Curved OLED Gaming Screen 1', 799.99, (SELECT id FROM category WHERE name = 'Screens')),
    (nextval('product_seq'), 18, 'Flat QLED monitor with 1440p resolution', 'QLED Monitor 1', 599.99, (SELECT id FROM category WHERE name = 'Screens')),
    (nextval('product_seq'), 22, '27-inch touch screen display for creative work', 'Touch Screen Display 1', 699.99, (SELECT id FROM category WHERE name = 'Screens')),
    (nextval('product_seq'), 20, 'Ultra-slim 4K HDR display for multimedia', 'Ultra-slim 4K HDR Display 1', 449.99, (SELECT id FROM category WHERE name = 'Screens')),
    (nextval('product_seq'), 25, 'Gaming projector with low input lag', 'Gaming Projector 1', 899.99, (SELECT id FROM category WHERE name = 'Screens'));

-- Insert products for the 'Mice' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 30, 'Wireless gaming mouse with customizable RGB lighting', 'RGB Gaming Mouse 1', 59.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'), 28, 'Ergonomic wired mouse for productivity', 'Ergonomic Wired Mouse 1', 29.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'), 32, 'Ambidextrous gaming mouse with high DPI', 'Ambidextrous Gaming Mouse 1', 69.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'), 26, 'Travel-sized compact mouse for laptops', 'Travel Mouse 1', 19.99, (SELECT id FROM category WHERE name = 'Mice')),
    (nextval('product_seq'), 35, 'Vertical ergonomic mouse for reduced strain', 'Vertical Ergonomic Mouse 1', 39.99, (SELECT id FROM category WHERE name = 'Mice'));

-- Insert products for the 'Accessories' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 25, 'Adjustable laptop stand with cooling fan', 'Adjustable Laptop Stand 1', 34.99, (SELECT id FROM category WHERE name = 'Accessories')),
    (nextval('product_seq'), 20, 'Wireless charging pad for smartphones', 'Wireless Charging Pad 1', 24.99, (SELECT id FROM category WHERE name = 'Accessories')),
    (nextval('product_seq'), 28, 'Gaming headset stand with RGB lighting', 'RGB Headset Stand 1', 49.99, (SELECT id FROM category WHERE name = 'Accessories')),
    (nextval('product_seq'), 22, 'Bluetooth mechanical keypad for tablets', 'Bluetooth Keypad 1', 39.99, (SELECT id FROM category WHERE name = 'Accessories')),
    (nextval('product_seq'), 30, 'External hard drive enclosure with USB-C', 'External Hard Drive Enclosure 1', 29.99, (SELECT id FROM category WHERE name = 'Accessories'));

-- Insert products for the 'Laptops' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 8, '14-inch lightweight laptop with Intel i7 processor', 'Ultrabook Laptop 1', 899.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'), 12, '15.6-inch gaming laptop with RTX graphics', 'Gaming Laptop 1', 1499.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'), 10, 'Business laptop with fingerprint sensor', 'Business Laptop 1', 1199.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'), 6, '2-in-1 convertible laptop with touchscreen', 'Convertible Laptop 1', 999.99, (SELECT id FROM category WHERE name = 'Laptops')),
    (nextval('product_seq'), 14, 'Affordable laptop for students', 'Student Laptop 1', 499.99, (SELECT id FROM category WHERE name = 'Laptops'));

-- Insert products for the 'Headphones' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 25, 'Over-ear noise-cancelling headphones', 'Noise-Cancelling Headphones 1', 199.99, (SELECT id FROM category WHERE name = 'Headphones')),
    (nextval('product_seq'), 30, 'Wireless earbuds with charging case', 'Wireless Earbuds 1', 149.99, (SELECT id FROM category WHERE name = 'Headphones')),
    (nextval('product_seq'), 20, 'Gaming headset with surround sound', 'Gaming Headset 1', 129.99, (SELECT id FROM category WHERE name = 'Headphones')),
    (nextval('product_seq'), 35, 'Lightweight on-ear headphones for travel', 'Travel Headphones 1', 89.99, (SELECT id FROM category WHERE name = 'Headphones')),
    (nextval('product_seq'), 28, 'In-ear headphones with built-in microphone', 'In-Ear Headphones 1', 59.99, (SELECT id FROM category WHERE name = 'Headphones'));

-- Insert products for the 'Printers' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 10, 'All-in-one wireless printer', 'Wireless Printer 1', 179.99, (SELECT id FROM category WHERE name = 'Printers')),
    (nextval('product_seq'), 12, 'Compact photo printer', 'Photo Printer 1', 99.99, (SELECT id FROM category WHERE name = 'Printers')),
    (nextval('product_seq'), 8, 'Laser printer with duplex printing', 'Laser Printer 1', 249.99, (SELECT id FROM category WHERE name = 'Printers')),
    (nextval('product_seq'), 14, 'High-speed inkjet printer', 'Inkjet Printer 1', 129.99, (SELECT id FROM category WHERE name = 'Printers')),
    (nextval('product_seq'), 15, 'Portable printer for mobile devices', 'Portable Printer 1', 149.99, (SELECT id FROM category WHERE name = 'Printers'));

-- Insert products for the 'Webcams' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 20, '1080p HD webcam with microphone', 'HD Webcam 1', 79.99, (SELECT id FROM category WHERE name = 'Webcams')),
    (nextval('product_seq'), 18, '4K Ultra HD webcam with autofocus', '4K Webcam 1', 129.99, (SELECT id FROM category WHERE name = 'Webcams')),
    (nextval('product_seq'), 22, 'Webcam with privacy shutter', 'Privacy Webcam 1', 69.99, (SELECT id FROM category WHERE name = 'Webcams')),
    (nextval('product_seq'), 25, 'Wide-angle webcam for streaming', 'Streaming Webcam 1', 99.99, (SELECT id FROM category WHERE name = 'Webcams')),
    (nextval('product_seq'), 30, 'Compact webcam for laptops', 'Laptop Webcam 1', 49.99, (SELECT id FROM category WHERE name = 'Webcams'));

-- Insert products for the 'Networking Equipment' category
INSERT INTO public.product (id, available_quantity, description, name, price, category_id)
VALUES
    (nextval('product_seq'), 15, 'Dual-band Wi-Fi router with 4 antennas', 'Wi-Fi Router 1', 89.99, (SELECT id FROM category WHERE name = 'Networking Equipment')),
    (nextval('product_seq'), 10, 'Mesh Wi-Fi system for whole home coverage', 'Mesh Wi-Fi System 1', 199.99, (SELECT id FROM category WHERE name = 'Networking Equipment')),
    (nextval('product_seq'), 18, 'Gigabit Ethernet switch with 8 ports', 'Ethernet Switch 1', 49.99, (SELECT id FROM category WHERE name = 'Networking Equipment')),
    (nextval('product_seq'), 12, 'Powerline adapter kit for extended network', 'Powerline Adapter Kit 1', 79.99, (SELECT id FROM category WHERE name = 'Networking Equipment')),
    (nextval('product_seq'), 20, 'Network-attached storage with RAID support', 'NAS Device 1', 299.99, (SELECT id FROM category WHERE name = 'Networking Equipment'));
