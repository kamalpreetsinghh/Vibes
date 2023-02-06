package com.cleverlycode.vibes.data.service.impl

import com.cleverlycode.vibes.data.model.Profile
import com.cleverlycode.vibes.data.service.ProfileService
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class ProfileServiceImpl @Inject constructor() : ProfileService {
    override fun createProfile(profile: Profile) {
        Firebase.firestore
            .collection("profiles")
            .add(profile)
            .addOnCompleteListener {
            }
    }

    override fun getProfileDetails(): Profile {
        Firebase.firestore
            .collection("profiles")
            .document("")
            .get()

        return Profile()
    }

    override fun updateProfileDetails(profile: Profile) {
        TODO("Not yet implemented")
    }
}