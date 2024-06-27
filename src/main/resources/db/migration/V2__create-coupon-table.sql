CREATE TABLE coupon (
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    code VARCHAR(100) NOT NULL,
    discount INTEGER NOT NULL,
    valid_from TIMESTAMP NOT NULL,
    expire_in TIMESTAMP NOT NULL,
    event_id UUID,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (event_id) REFERENCES event(id) ON DELETE CASCADE
);