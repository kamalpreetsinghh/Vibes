package com.cleverlycode.vibes.data.service

import com.cleverlycode.vibes.data.model.Profile

interface ProfileService {
    fun createProfile(profile: Profile)
    fun getProfileDetails(): Profile
    fun updateProfileDetails(profile: Profile)
}