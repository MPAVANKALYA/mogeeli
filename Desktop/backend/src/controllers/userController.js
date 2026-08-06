const User = require("../models/User");

const registerUser = async (req, res) => {

    try {

        const {
            firstName,
            lastName,
            email,
            phoneNumber,
            password,
            confirmPassword
        } = req.body;

        if (
            !firstName ||
            !lastName ||
            !email ||
            !phoneNumber ||
            !password ||
            !confirmPassword
        ) {

            return res.status(400).json({
                message: "All fields are required"
            });

        }

        if (password !== confirmPassword) {

            return res.status(400).json({
                message: "Passwords do not match"
            });

        }

        const existingUser = await User.findOne({ email });

        if (existingUser) {

            return res.status(400).json({
                message: "Email already exists"
            });

        }

        const user = await User.create({
            firstName,
            lastName,
            email,
            phoneNumber,
            password
        });

        return res.status(201).json({
            success: true,
            message: "User Registered Successfully",
            data: user
        });

    } catch (error) {

        return res.status(500).json({
            success: false,
            message: error.message
        });

    }

};

module.exports = {
    registerUser
};